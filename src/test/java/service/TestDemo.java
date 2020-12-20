package service;

import com.datahub.mybatis.mapper.SubsidiaryInformationMapper;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

/**
 * Create by HuQiuYue on 2020/6/1
 */

@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class TestDemo {

    @Autowired
    private SubsidiaryInformationMapper subsidiaryInformationMapper;

    public static void getdemo(){

        Response response = given().accept("*/*")
                .param("ie","utf-8")
                .param("wd","maycur")
                .get("https://www.baidu.com/");

        System.out.println(response.getStatusCode());
        System.out.println(response.body().toString());

    }

    @Test
    public void test(){
        System.out.println(subsidiaryInformationMapper);
        subsidiaryInformationMapper.getAllSubsidiaryInfo("EC2006011C0ZIY2S");

    }



}
