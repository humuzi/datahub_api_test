package com.datahub.web.steps;

import com.datahub.common.constant.Constant;
import com.datahub.web.runtime.WebLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.mybatis.mapper.SubsidiaryInformationMapper;
import com.datahub.web.dto.InitResult;

import com.datahub.web.dto.responseDto.BaseMetaInfoDto;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/7/8
 */
//@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class InitStepDef extends WebLoginStepDef {
    @Autowired private WebLoginUser loginUser;
    @Autowired private SubsidiaryInformationMapper subsidiaryInformationMapper;

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void init(String entCode){
        Response response = given().accept("application/json")
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.WEB_INIT_URL);

        InitResult  result = response.getBody().as(InitResult.class);
        List<BaseMetaInfoDto> actualSubsidiary = result.getData().getSubsidiaries();
        BaseMetaInfoDto expectSubsidiary = subsidiaryInformationMapper.getSubsidiaryInfo(entCode);
        assertThat(response.getStatusCode(),equalTo(200));
        assertThat(actualSubsidiary,containsInAnyOrder(expectSubsidiary));
    }
}
