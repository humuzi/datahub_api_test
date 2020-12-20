package com.datahub.platform.steps;



import com.datahub.common.dto.ResponseDto;
import com.datahub.common.dto.RetDto;
import com.datahub.common.util.ExcelUtil;
import com.datahub.domain.SubsidiaryInformation;
import com.datahub.platform.dto.response.AllSubsidiaryResult;
import com.datahub.platform.dto.SubsidiaryInfo;
import com.datahub.platform.dto.response.SubsidiaryResult;
import com.datahub.platform.dto.response.SubsidiaryTreeResult;
import com.datahub.common.constant.Constant;
import com.datahub.common.runtime.PlatformLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.mybatis.mapper.SubsidiaryInformationMapper;
import com.datahub.platform.runtime.BaseForm;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;



/**
 * Create by HuQiuYue on 2020/6/9
 */
public class SubsidiaryStepDef extends AuthLoginStepDef{

    private static final Logger logger = LoggerFactory.getLogger(SubsidiaryStepDef.class);

    @Autowired private PlatformLoginUser loginUser;
    @Autowired private SubsidiaryInformationMapper subsidiaryInformationMapper;
    @Autowired private BaseForm subsidiaryForm;


    @Parameters({"entCode"})
    @Test(groups = {"platform"})
    public void getAllSubsidiary(String entCode){
        logger.info("**********获取全部subsidiaryCode*************");

        Response response = given().accept("application/json")
                .param("skipInactive",true)
                .header("entCode",entCode)
                .header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getPlatformBaseUrl() + Constant.SEARCH_ALL_SUBSIDIARY_URL);

        List<SubsidiaryInfo> actualAllSubsidiary = response.getBody().as(AllSubsidiaryResult.class).getData();
        Iterator iterator = actualAllSubsidiary.iterator();
        List actualSubsidiaryCodes = new ArrayList();
        while(iterator.hasNext()){
            SubsidiaryInfo subsidiaryInfo = (SubsidiaryInfo) iterator.next();
            String subsidiaryCode = subsidiaryInfo.getCode();
            actualSubsidiaryCodes.add(subsidiaryCode);
        }

        List<String> expectedSubsidiaryCodes = subsidiaryInformationMapper.getAllSubsidiaryCodes(entCode);
        logger.info("The expected subsidiaryCodes are " + expectedSubsidiaryCodes + ",and the actual subsidiaryCodes are " + actualSubsidiaryCodes);
        assertThat(actualAllSubsidiary.retainAll(expectedSubsidiaryCodes),equalTo(true));

        logger.info("测试OK");
    }



    @Parameters({"entCode"})
    @Test(groups= {"platform"})
    public void getSubsidiaryByCode(String entCode) throws IOException {
        logger.info("************根据Code获取业务实体信息*************");
        File testFile = new File(ConfigUtil.getTestDataPath() + "/Excel/subsidiaryCodes.xlsx");
        Workbook workbook = WorkbookFactory.create(testFile);
        List codes = ExcelUtil.getStringFromExcelFile(workbook,0,0);

        Iterator<String> iterator = codes.iterator();
        while(iterator.hasNext()){
            String businessCode = iterator.next();
            Response response = given().accept("application/json")
                    .param("businessCode",businessCode)
                    .header("entCode",entCode)
                    .header("tokenId",loginUser.getTokenId())
                    .get(ConfigUtil.getPlatformBaseUrl() + Constant.SUBSIDIARY_INFO_URL);

            SubsidiaryInfo subsidiaryInfo = response.getBody().as(SubsidiaryResult.class).getData();
            String actualCode =subsidiaryInfo.getCode();
            String actualName = subsidiaryInfo.getName();
            String actualTaxNo = subsidiaryInfo.getTaxNo();

            SubsidiaryInformation subsidiaryInformation = subsidiaryInformationMapper.getSubsidiaryDetail(entCode,businessCode);
            String expectedCode = subsidiaryInformation.getCode();
            String expectedName = subsidiaryInformation.getName();
            String expectedTaxNo = subsidiaryInformation.getTaxNo();

            logger.info("The actual code ,name, taxNo is (" + actualCode + "," +actualName + "," +actualTaxNo + ").");
            logger.info("The expected code ,name, taxNo is (" + expectedCode + "," +expectedName + "," +expectedTaxNo + ").");
            assertThat(actualCode,equalTo(expectedCode));
            assertThat(actualName,equalTo(expectedName));
            assertThat(actualTaxNo,equalTo(expectedTaxNo));
        }
        logger.info("测试OK");
    }



    @Parameters({"entCode"})
    @Test(groups = {"platform"})
    public void getSubsidiaryTree(String entCode){
        Response response = given().accept("application/json")
            .param("businessCode","")
            .param("skipInactive",true)
            .header("entCode",entCode)
            .header("tokenId",loginUser.getTokenId())
            .get(ConfigUtil.getPlatformBaseUrl() + Constant.SEARCH_SUBSIDIARY_TREE_URL);

        List<String> actualSubsidiaryCode = null;
        for(int i = 0;i <= response.getBody().as(SubsidiaryTreeResult.class).getData().size();i++){
            String subsidiaryCode = response.getBody().as(SubsidiaryTreeResult.class).getData().get(i).getCode();
                actualSubsidiaryCode.add(subsidiaryCode);
            }
                    List<String> expectedSubsidiaryCode = subsidiaryInformationMapper.getSubsidiaryTree(entCode,"");
            assertThat(actualSubsidiaryCode,equalTo(expectedSubsidiaryCode));
            assertThat(actualSubsidiaryCode,containsInAnyOrder(expectedSubsidiaryCode.toArray()));
    }


    @Parameters({"entCode"})
    @Test(groups = {"platform"})
    public void saveSubsidiary(String entCode) throws Throwable {
        logger.info("************保存业务实体*************");

        String subsidiaryInfo = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/subsidiaryInfoSave.json"),"UTF-8");
        Response response = given().accept("application/json").contentType(ContentType.JSON)
        .header("entCode",entCode)
        .header("tokenId",loginUser.getTokenId())
        .body(subsidiaryInfo)
        .post(ConfigUtil.getPlatformBaseUrl() + Constant.ADD_SUBSIDIARY_URL);

        System.out.println(response.getBody().jsonPath().get("data"));
        assertThat(response.getStatusCode(),equalTo(200));

        ResponseDto<List<RetDto>,String>  result = response.getBody().as(ResponseDto.class);
        List<RetDto> myObjects =
                new ObjectMapper().convertValue(result.getData(), new TypeReference<List<RetDto>>(){});
        String businessCode = myObjects.get(0).getBusinessCode();
        subsidiaryForm.setBusinessCode(businessCode);


    }

    @Parameters({"entCode"})
    @Test(groups = {"platform"},dependsOnMethods = {"saveSubsidiary"})
    public void disableSubsidiary(String entCode){

        String businessCode = subsidiaryForm.getBusinessCode();
        logger.info("************禁用业务实体" + businessCode + "*************");
        Response response = given().accept("application/json")
        .param("businessCode",businessCode)
        .header("entCode",entCode)
        .header("tokenId",loginUser.getTokenId())
        .post(ConfigUtil.getPlatformBaseUrl() + Constant.DISABLE_SUBSIDIARY_URL);

        assertThat(response.getStatusCode(),equalTo(200));
        assertThat(response.getBody().asString(), response.getBody().jsonPath().get("code"), Matchers.<Object>equalTo("ACK"));
    }


    @Parameters({"entCode"})
    @Test(groups = {"platform"},dependsOnMethods = {"disableSubsidiary"})
    public void deleteSubsidiary(String entCode){
        String businessCode = subsidiaryForm.getBusinessCode();
        logger.info("************删除业务实体" + businessCode + "*************");
        Response response = given().accept("application/json")
                .param("businessCode",businessCode)
                .header("entCode",entCode)
                .header("tokenId",loginUser.getTokenId())
                .delete(ConfigUtil.getPlatformBaseUrl() + Constant.DELETE_SUBSIDIARY_URL);

        assertThat(response.getStatusCode(),equalTo(200));
        logger.info("清空测试数据");
        subsidiaryInformationMapper.deleteData(entCode,businessCode);
    }

}


