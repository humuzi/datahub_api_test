package com.datahub.platform.steps;

import com.datahub.common.constant.Constant;
import com.datahub.common.dto.ResponseDto;
import com.datahub.common.dto.RetDto;
import com.datahub.common.runtime.PlatformLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.domain.DepartmentInformation;
import com.datahub.mybatis.mapper.DepartmentInformationMapper;
import com.datahub.platform.dto.DepartmentInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/12/8
 */
public class DepartmentStepDef extends AuthLoginStepDef {
    @Autowired private PlatformLoginUser loginUser;
    @Autowired private DepartmentInformationMapper departmentInformationMapper;

    List<String> businessCodes = new ArrayList<>();

    @Parameters("entCode")
    @Test(groups = {"xigua"})
    public void saveDepartment(String entCode) throws IOException {
        logger.info("*******保存部门信息**********");
        String departmentInfo = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath()+"/Json/departmentSaveInfo.json"),"UTF-8");

        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .body(departmentInfo)
                .post(ConfigUtil.getPlatformBaseUrl() + Constant.ADD_DEPARTMENT_URL);

        ResponseDto<List<RetDto>,String> result = response.getBody().as(ResponseDto.class);
        List<RetDto> retDto = new ObjectMapper().convertValue(result.getData(), new TypeReference<List<RetDto>>() {});

        Iterator<RetDto> iterator = retDto.iterator();
        while(iterator.hasNext()){
            RetDto ret = iterator.next();
            String businessCode = ret.getBusinessCode();
            businessCodes.add(businessCode);
        }
        assertThat(response.getStatusCode(),equalTo(200));
        assertThat(result.getCode(),equalTo("ACK"));
        logger.info(businessCodes);
        logger.info("测试OK");
    }


    @Parameters("entCode")
    @Test(groups = {"platform"},dependsOnMethods = {"saveDepartment"})
    public void getDepartmentDetail(String entCode){
        logger.info("*******获取部门详细信息**********");
        Iterator<String> iterator = businessCodes.iterator();
        while(iterator.hasNext()){
            String businessCode = iterator.next();
            Response response = given().accept("application/json")
                    .param("businessCode",businessCode)
                    .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                    .get(ConfigUtil.getPlatformBaseUrl() + Constant.DEPARTMENT_INFO_URL);

            ResponseDto<DepartmentInfo,String> result= response.getBody().as(ResponseDto.class);
            DepartmentInfo department = new ObjectMapper().convertValue(result.getData(), new TypeReference<DepartmentInfo>() {});
            String actualCode = department.getCode();
            String actualName = department.getName();

            DepartmentInformation departmentInformation = departmentInformationMapper.getDepartmentInfo(entCode,businessCode);
            String expectedCode = departmentInformation.getCode();
            String expectedName = departmentInformation.getName();

            logger.info("The actualCode is " + actualCode + ",the expectedCode is " + expectedCode);
            logger.info("The actualCode is " + actualName + ",the expectedCode is " + expectedName);
            assertThat(actualCode,equalTo(expectedCode));
            assertThat(actualName,equalTo(expectedName));
        }
        logger.info("测试OK");
    }

    @Parameters("entCode")
    @Test(groups = {"xigua"})
    public void getAllDepartment(String entCode){
        logger.info("*******获取全部部门详细信息**********");
        Response response = given().accept("application/json")
                .param("skipInactive",false)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getPlatformBaseUrl() + Constant.SEARCH_ALL_DEPARTMENT_URL);


        ResponseDto<List<DepartmentInfo>,String> responseDto = response.getBody().as(ResponseDto.class);
        List<DepartmentInfo>  result = new ObjectMapper().convertValue(responseDto.getData(), new TypeReference<List<DepartmentInfo>>() {});
        List<String> actualDepartmentCodes = new ArrayList<>();
        Iterator<DepartmentInfo> iterator = result.iterator();
        while (iterator.hasNext()){
            String departmentCode = iterator.next().getCode();
            actualDepartmentCodes.add(departmentCode);
        }
        List<String> expectedDepartmentCodes = departmentInformationMapper.getDepartmentCodes(entCode);

        logger.info("The actualDepartmentCodes is " + actualDepartmentCodes + ", the expectedDepartmentCodes is " + expectedDepartmentCodes);
        assertThat(actualDepartmentCodes.containsAll(expectedDepartmentCodes),equalTo(true));
    }




    public void savePrincipal(String entCode){
        logger.info("*******保存部门负责人信息**********");
    }


    @AfterClass(dependsOnMethods = {"saveDepartment"})
    @Parameters("entCode")
    public void deleteDepartment(String entCode){
        logger.info("*******删除部门**********");
        Iterator<String> iterator = businessCodes.iterator();
        while(iterator.hasNext()){
            String businessCode = iterator.next();
            Response response = given().accept("application/json")
                    .param("businessCode",businessCode)
                    .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                    .delete(ConfigUtil.getPlatformBaseUrl() + Constant.DELETE_DEPARTMENT_URL);

            assertThat(response.getStatusCode(),equalTo(200));
            assertThat(response.getBody().asString(),response.getBody().jsonPath().get("code"), Matchers.<Object>equalTo("ACK"));
        }
    }




}




