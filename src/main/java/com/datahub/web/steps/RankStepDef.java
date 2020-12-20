package com.datahub.web.steps;

import com.datahub.common.constant.Constant;
import com.datahub.common.util.ConfigUtil;
import com.datahub.mybatis.mapper.RankInformationMapper;
import com.datahub.web.dto.responseDto.RankDto;
import com.datahub.web.dto.RankResult;
import com.datahub.web.runtime.WebLoginUser;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/9/22
 */

public class RankStepDef extends WebLoginStepDef {
    @Autowired private RankInformationMapper rankInformationMapper;
    @Autowired private WebLoginUser loginUser;

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getRanks(String entCode){
        Response response = given().accept("application/json")
                .param("skipInactive",true)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.ALL_RANK_INFO_URL);

        List<RankDto> rankResult = response.getBody().as(RankResult.class).getData();
        List actualRanNames = null;
        for(RankDto rankDto:rankResult){
            actualRanNames.add(rankDto.getName());
        }

        List expectedRankNames = rankInformationMapper.getRankNames(entCode);
        assertThat(actualRanNames.retainAll(expectedRankNames),equalTo(true));
    }
}
