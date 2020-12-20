package com.datahub.platform.steps;

import com.datahub.common.constant.Constant;
import com.datahub.common.dto.ResponseDto;
import com.datahub.common.dto.RetDto;
import com.datahub.common.runtime.PlatformLoginUser;
import com.datahub.common.util.ConfigUtil;
import com.datahub.domain.EntEmployee;
import com.datahub.mybatis.mapper.EntApplicationUserMapper;
import com.datahub.mybatis.mapper.EntEmployeeMapper;
import com.datahub.platform.dto.EmployeeAppBoundDetailDto;
import com.datahub.platform.runtime.BaseForm;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/11/16
 */
public class PlatFormEmployeeDefStep extends AuthLoginStepDef {
    private static final Logger logger = LoggerFactory.getLogger(PlatFormEmployeeDefStep.class);

    @Autowired private PlatformLoginUser loginUser;
    @Autowired private BaseForm baseForm;
    @Autowired private EntApplicationUserMapper entApplicationUserMapper;
    @Autowired private EntEmployeeMapper entEmployeeMapper;

    @Parameters({"entCode"})
    @Test(groups = {"platform"})
    public void saveEmployee(String entCode) throws IOException {
        logger.info("*************批量保存员工信息*************");

        String subsidiaryInfo = IOUtils.toString(new FileInputStream(ConfigUtil.getTestDataPath() + "/Json/employeeSaveInfo.json"),"UTF-8");
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode",entCode)
                .header("tokenId",loginUser.getTokenId())
                .body(subsidiaryInfo)
                .post(ConfigUtil.getPlatformBaseUrl() + Constant.ADD_MEMBER_URL);

        ResponseDto<List<RetDto>,String> result = response.getBody().as(ResponseDto.class);
        assertThat(result.getCode(),equalTo("ACK"));
        assertThat(response.getStatusCode(),equalTo(200));
        List<RetDto> myObjects =
                new ObjectMapper().convertValue(result.getData(), new TypeReference<List<RetDto>>(){});
        String businessCode = myObjects.get(0).getBusinessCode();
        baseForm.setBusinessCode(businessCode);

    }

    @Parameters("entCode")
    @Test(groups = {"platform"},dependsOnMethods = {"saveEmployee"})
    public void getEmployeeDetail(String entCode){
        String sourceId = baseForm.getBusinessCode();
        String source = "MAYCUR_NG";
        Response response = given().accept("application/json")
                .param("source",source).param("sourceId",sourceId)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getPlatformBaseUrl() + Constant.EMPLOYEE_DETAIL_URL);

    }


    @Parameters("entCode")
    @Test(groups = {"platform"})
    public void getUserBindInfo(String entCode){
        String employeeSourceId = "UI2011301WNHSI68";
        String source = "MAYCUR-NG";
        Response response = given().accept("application/json")
                .param("employeeSourceId",employeeSourceId).param("source",source)
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getPlatformBaseUrl() +Constant.EMPLOYEE_BOUND_INFO_URL);

        ResponseDto<List<EmployeeAppBoundDetailDto>,String> result = response.getBody().as(ResponseDto.class);
        List<EmployeeAppBoundDetailDto> employeeAppDetailDtos = new ObjectMapper().convertValue(result.getData(), new TypeReference<List<EmployeeAppBoundDetailDto>>(){});

        List<String> actualAppCodes = new ArrayList<>();
        for(int i=0;i<employeeAppDetailDtos.size();i++){
            EmployeeAppBoundDetailDto employeeAppDetail = employeeAppDetailDtos.get(i);
            String appCode = employeeAppDetail.getAppCode();
            String status = employeeAppDetail.getDisplayOpenStatus();
            String appAccount = employeeAppDetail.getAppAccount();
            if(status.equals("已开通") && appAccount != null){
                actualAppCodes.add(appCode);
            }
        }

        String employeeCode = entEmployeeMapper.getEmployeeCode(entCode,employeeSourceId);
        List<String> expectedAppCodes = entApplicationUserMapper.getAppCode(entCode,employeeCode);

        logger.info("The actual bind appCodes " + actualAppCodes + ",expected bind appCodes " + expectedAppCodes);
        assertThat(actualAppCodes.retainAll(expectedAppCodes),equalTo(true));

        logger.info("测试OK");
    }




}

