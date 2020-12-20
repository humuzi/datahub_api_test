package com.datahub.web.steps;

import com.datahub.common.constant.Constant;
import com.datahub.web.runtime.WebLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.mybatis.mapper.EnterpriseMapper;
import com.datahub.web.dto.EnterpriseResult;
import com.datahub.web.dto.responseDto.Enterprise;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/8/19
 */
public class EnterpriseStepDef extends WebLoginStepDef {
    private static final Logger logger = LoggerFactory.getLogger(EnterpriseStepDef.class);

    @Autowired private WebLoginUser loginUser;
    @Autowired private EnterpriseMapper enterpriseMapper;


    @Test(groups = {"web"})
    @Parameters({"entCode"})
    public void getEnterpriseDetail(String entCode){
        logger.info("**********获取企业详情**********");

        Response response = given().accept("application/json")
                .param("code",entCode)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.ENTERPRISE_DETAIL_URL);

        String actualName = null;

        try{
            Enterprise enterprise = response.getBody().as(EnterpriseResult.class).getData();
            actualName = enterprise.getName();
        }catch (Exception e){
            logger.error("get responseError.}",e);
        }

        String expectName = enterpriseMapper.getEnterpriseName(entCode);

        assertThat(response.getBody().as(EnterpriseResult.class).getCode(),equalTo("ACK"));
        assertThat(actualName,equalTo(expectName));
        logger.info("测试通过");

    }
}
