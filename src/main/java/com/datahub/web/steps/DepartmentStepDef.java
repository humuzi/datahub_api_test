package com.datahub.web.steps;

import com.datahub.common.constant.Constant;
import com.datahub.common.util.ExcelUtil;
import com.datahub.domain.DepartmentInformation;
import com.datahub.web.runtime.WebLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.mybatis.mapper.DepartmentInformationMapper;
import com.datahub.web.dto.DepartmentResult;
import com.datahub.web.dto.responseDto.DepartmentDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONObject;
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
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/8/21
 */

public class DepartmentStepDef extends WebLoginStepDef {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentStepDef.class);

    @Autowired private WebLoginUser loginUser;
    @Autowired private DepartmentInformationMapper departmentInformationMapper;


    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getFirstDepartment(String entCode){
        logger.info("**********获取根部门信息**********");

        String parentCode = "";
        Response response = given().accept("application/json")
                .param("parentCode",parentCode).param("skipInactive",false)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.DEPARTMENT_DETAIL_URL);

        String actualDepartmentCode = null;
        String actualDepartmentName = null;
        String actualPrincipalEmployeeCode = null;
        try{
            List<DepartmentDto> department = response.getBody().as(DepartmentResult.class).getData();
            actualDepartmentCode = department.get(0).getCode();
            actualDepartmentName = department.get(0).getName();
            actualPrincipalEmployeeCode = department.get(0).getPrincipalEmployeeCode();
        }catch (Exception e){
            logger.error("get response error.",e);
        }

        String expectDepartmentCode = departmentInformationMapper.getFirstDepartmentInformation(entCode).getCode();
        String expectDepartmentName = departmentInformationMapper.getFirstDepartmentInformation(entCode).getName();
        String expectPrincipalEmployeeCode = departmentInformationMapper.getFirstDepartmentInformation(entCode).getPrincipalEmployeeCode();

        assertThat(actualDepartmentCode,equalTo(expectDepartmentCode));
        assertThat(actualDepartmentName,equalTo(expectDepartmentName));
        assertThat(actualPrincipalEmployeeCode,equalTo(expectPrincipalEmployeeCode));
        logger.info("测试通过");
    }

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getDepartmentList(String entCode){
        logger.info("**********获取部门列表信息**********");

        String departmentCode = departmentInformationMapper.getFirstDepartmentInformation(entCode).getCode();
        Response response = given().accept("application/json")
                .param("parentCode",departmentCode).param("skipInactive",false)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.DEPARTMENT_DETAIL_URL);

        List<DepartmentDto> department = response.getBody().as(DepartmentResult.class).getData();
        List departmentCodes = new ArrayList();
        for(int i = 0;i<department.size();i++){
            String code = department.get(i).getCode();
            departmentCodes.add(code);
        }

        List expectDepartmentCode = departmentInformationMapper.getSubDepartmentCode(entCode,departmentCode);
        assertThat(response.statusCode(),equalTo(200));
        assertThat((departmentCodes.retainAll(expectDepartmentCode)),equalTo(true));

        logger.info("测试通过");
    }

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void searchDepartment(String entCode) throws IOException {
        logger.info("**********搜索部门信息**********");
        File file = new File(ConfigUtil.getTestDataPath() + "/Excel/department.xlsx");
        Workbook workbook = WorkbookFactory.create(file);
        List list = ExcelUtil.getStringFromExcelFile(workbook,0,0);

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String keyword = iterator.next();
            JSONObject body = new JSONObject().put("keyword",keyword);

            Response response = given().accept("application/json").contentType(ContentType.JSON)
                    .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                    .body(body.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.SEARCH_DEPARTMENT_INFO_URL);
            List<DepartmentDto> department = response.getBody().as(DepartmentResult.class).getData();

            String actualHireDepartmentCode= department.get(0).getHeirCode();
            Boolean actualActive = department.get(0).isActive();

            System.out.println(departmentInformationMapper.searchDepartmentByName(entCode,keyword));
            DepartmentInformation departmentInformation = departmentInformationMapper.searchDepartmentByName(entCode,keyword);
            String expectHireDepartmentCode = departmentInformationMapper.searchDepartmentByName(entCode,keyword).getHeirCode();
            Boolean expectActive = departmentInformationMapper.searchDepartmentByName(entCode,keyword).getActive();

            assertThat(response.getBody().as(DepartmentResult.class).getCode(),equalTo("ACK"));
            assertThat(actualHireDepartmentCode,equalTo(expectHireDepartmentCode));
            assertThat(actualActive,equalTo(expectActive));
        }

        logger.info("测试通过");

    }
}
