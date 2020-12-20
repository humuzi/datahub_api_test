package com.datahub.web.steps;

import com.datahub.common.constant.Constant;
import com.datahub.common.util.ConfigUtil;
import com.datahub.common.util.ExcelUtil;
import com.datahub.mybatis.mapper.PositionInformationMapper;
import com.datahub.web.dto.PositionResult;
import com.datahub.web.dto.responseDto.PositionDto;
import com.datahub.web.runtime.WebLoginUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Create by HuQiuYue on 2020/9/22
 */

public class PositionStepDef extends WebLoginStepDef {
    private static final Logger logger = LoggerFactory.getLogger(PositionStepDef.class);

    @Autowired private WebLoginUser loginUser;
    @Autowired private PositionInformationMapper positionInformationMapper;

    @Parameters({"entCode"})
    @Test(groups = {"muzi"})
    public void getALLPositions(String entCode){
        logger.info("**************获取职位***********");
        String parentCode = "";
        Response response = given().accept("application/json")
                .param("parentCode",parentCode)
                .param("skipInactive",false)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.ALL_POSITION_INFO_URL);

        List<PositionDto> positionResult = response.getBody().as(PositionResult.class).getData();
        List actualPositionNames = null;
        for(PositionDto positionDto:positionResult){
            actualPositionNames.add(positionDto.getName());
        }
        List expectedPositionNames = positionInformationMapper.getAllPosition(entCode);
        assertThat(actualPositionNames,containsInAnyOrder(expectedPositionNames));
    }


//    通过关键字搜索职位
    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void searchPositionByKeyword(String entCode) throws IOException {
        logger.info("**************通过关键字搜索职位***********");

        File testFile = new File(ConfigUtil.getTestDataPath() + "/Excel/testExcel.xlsx");
        Workbook workbook = WorkbookFactory.create(testFile);
        List keywords = ExcelUtil.getStringFromExcelFile(workbook,0,0);

        Iterator<String> iterator = keywords.iterator();
        while(iterator.hasNext()){
            String keyword = iterator.next();
            Response response1 = given().accept("application/json").contentType(ContentType.JSON)
                    .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                    .body(keyword).post(ConfigUtil.getWebBaseUrl() + Constant.POSITION_SEARCH_BY_KEYWORD_URL);

            List<PositionDto> positionResult1 = response1.getBody().as(PositionResult.class).getData();
            List actualPositionNames = new ArrayList();
            for(PositionDto positionDto1:positionResult1){
                actualPositionNames.add(positionDto1.getName());
            }

            List expectedPositionNames = positionInformationMapper.searchPositionByKeyword(entCode,keyword);
            assertThat(actualPositionNames.retainAll(expectedPositionNames),equalTo(true));
        }


    }
}
