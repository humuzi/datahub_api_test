package com.datahub.platform.steps;

import com.datahub.common.constant.Constant;
import com.datahub.platform.dto.response.AuthLoginResult;
import com.datahub.platform.dto.LoginDto;
import com.datahub.common.runtime.PlatformLoginUser;
import com.datahub.common.util.ConfigUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;

/**
 * Create by HuQiuYue on 2020/6/5
 */


@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class AuthLoginStepDef extends AbstractTestNGSpringContextTests {

    @Autowired private PlatformLoginUser loginUser;

    @BeforeGroups(groups = {"xigua"})
//    @Test(groups={"xigua"})
    public  void login(){
        String platformCode = "PF20062417LD9AXS";
        String platformSecret = "shucqdatahub";
        Long timestamp = System.currentTimeMillis();
        String signature = getSecret(platformSecret,platformCode,timestamp);

        JSONObject body = new JSONObject().put("platformCode", platformCode)
                .put("signature", signature)
                .put("timestamp", timestamp);
        Response response = given().accept("application/json")
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post(ConfigUtil.getPlatformBaseUrl() + Constant.AUTH_LOGIN_URL);
        System.out.println(body.toString());

        LoginDto result = response.getBody().as(AuthLoginResult.class).getData();
        loginUser.setEntCode(result.getEntCode());
        loginUser.setTokenId(result.getTokenId());

        System.out.println(loginUser);
        System.out.println(timestamp);
    }

    public  String getSecret(String platformSecret,String platformCode,Long timeStamp){
        String secret = sha256Hex(platformSecret + ":" + platformCode + ":" + timeStamp);
        return secret;
    }

}


