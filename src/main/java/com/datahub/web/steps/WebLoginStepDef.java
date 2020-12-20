package com.datahub.web.steps;

import com.datahub.web.runtime.WebLoginUser;
import com.datahub.common.util.Base64Utils;
import com.datahub.web.dto.WebLoginResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeGroups;
import static io.restassured.RestAssured.given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Create by HuQiuYue on 2020/7/8
 */
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class WebLoginStepDef extends AbstractTestNGSpringContextTests {
    private static final Logger logger = LoggerFactory.getLogger(WebLoginStepDef.class);
    @Autowired private WebLoginUser loginUser ;
    Long timeStamp = System.currentTimeMillis();

    @BeforeGroups(groups = {"muzi"})
//    @Test(groups={"xigua"})
    public void webLogin() throws Throwable{
        logger.info("----获取token----");

        String platformId = "datahub";
        String platformSecret = "OHw0PiPZj1pBn7sCTZOy";
        String entCode = "EC2006301H5YODFQ";
        String userId = "0001";
        String whisper = "";

        Response response = given().accept("text/html").contentType(ContentType.TEXT)
                .param("platformId",platformId ).param("token",getSignature(platformSecret,platformId,entCode,userId,whisper,timeStamp))
                .param("entCode",entCode).param("userId",userId).param("whisper",whisper).param("timestamp",timeStamp)
                .redirects().follow(false)
                .expect().statusCode(302)
                .when()
                .get("https://uat.maycur.com/sso");

        String headerLocationValue= response.getHeader("location");
//        System.out.println("headerLocationValue : " + headerLocationValue);

        Response response1 = given().accept("text/html")
                .urlEncodingEnabled(false)
                .redirects().follow(false)
                .get(headerLocationValue);

        String headerLocationValue2 = response1.getHeader("location");
//        System.out.println("headerLocationValue2 : " + headerLocationValue2);

        String[] params = headerLocationValue2.split("=");
//        System.out.println(params[1]);

        String  loginResult = Base64Utils.decryptWithBase64(params[1]);

//        System.out.println(loginResult);
        WebLoginResult webLoginResult = new ObjectMapper().readValue(loginResult,WebLoginResult.class);
        System.out.println(webLoginResult);

        loginUser.setEntCode(webLoginResult.getEntCode());
        loginUser.setTokenId(webLoginResult.getAccessToken());

    }

    private String  getSignature(String MKPlatformSecret,String MKPlatformId, String entCode, String userId,String whisper, Long timestamp){
        String signature = DigestUtils.sha256Hex((MKPlatformSecret + ":" + MKPlatformId + ":" + entCode + ":"
                + userId + ":" + whisper + ":" + timestamp).getBytes());

        return signature;
    }
}


