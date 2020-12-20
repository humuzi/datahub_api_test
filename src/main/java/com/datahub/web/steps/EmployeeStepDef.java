package com.datahub.web.steps;

import com.datahub.common.constant.Constant;
import com.datahub.common.util.ConfigUtil;
import com.datahub.domain.EntEmployee;
import com.datahub.mybatis.mapper.EntApplicationInfoMapper;
import com.datahub.mybatis.mapper.EntEmployeeMapper;
import com.datahub.mybatis.mapper.RoleAssignmentMapper;
import com.datahub.web.dto.EmployeeDetailResult;
import com.datahub.web.dto.EmployeeListResult;
import com.datahub.web.dto.SyncInfoResult;
import com.datahub.web.dto.responseDto.EmployeeAppSimpleDto;
import com.datahub.web.dto.responseDto.PageInfo;
import com.datahub.web.dto.responseDto.RoleMetaDto;
import com.datahub.web.dto.responseDto.SimpleEmployeeResDto;
import com.datahub.web.runtime.WebLoginUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

/**
 * Create by HuQiuYue on 2020/9/9
 */

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class EmployeeStepDef extends AbstractTestNGSpringContextTests {

    @Autowired private WebLoginUser loginUser;
    @Autowired private EntEmployeeMapper entEmployeeMapper;
    @Autowired private RoleAssignmentMapper roleAssignmentMapper;
    @Autowired private EntApplicationInfoMapper entApplicationInfoMapper;

    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getEmployeeList(String entCode){
        JSONObject body = new JSONObject().put("keyword","").put("pageNo",1).put("pageSize",20);
        Response response = given().accept("application/json").contentType(ContentType.JSON)
                .header("entCode", entCode).header("tokenId", loginUser.getTokenId())
                .body(body.toString()).post(ConfigUtil.getWebBaseUrl() + Constant.EMPLOYEE_LIST_URL);

        PageInfo<SimpleEmployeeResDto>  employeeListResult = response.getBody().as(EmployeeListResult.class).getData();

        List actualEmployeeNames = null;

        for(int i=0;i<=employeeListResult.getList().size();i++){
            String name = employeeListResult.getList().get(i).getName();
            actualEmployeeNames.add(name);
        }

        long actualTotal = employeeListResult.getTotal();

        List expectEmployeeNames = Collections.singletonList(entEmployeeMapper.getEmployeeList(entCode).getCnName());
        long expectTotal = entEmployeeMapper.getEmployeeCount(entCode);
        assertThat(actualEmployeeNames,containsInAnyOrder(expectEmployeeNames));
        assertThat(actualTotal,equalTo(expectTotal));

    }

//    获取某个员工详情
    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void  getEmployeeDetail(String entCode){
        Response response = given().accept("application/json")
                .param("employeeCode", "")
                .header("entCode", entCode).header("tokenId", loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.EMPLOYEE_DETAIL_URL);

        EmployeeDetailResult employeeDetailResult = response.getBody().as(EmployeeDetailResult.class);
        String actualName = employeeDetailResult.getData().getName();
        String actualEmployeeId = employeeDetailResult.getData().getEmployeeId();
        List actualEmployeeRoles = null;
        for(int i = 0;i <= employeeDetailResult.getData().getEmployeeRoles().size();i++){
            RoleMetaDto role = employeeDetailResult.getData().getEmployeeRoles().get(i);
            actualEmployeeRoles.add(role);
        }

        EntEmployee entEmployee = entEmployeeMapper.getEmployeeDetail("employeeCode","EMP2006301A88349N");
        String expectName = entEmployee.getCnName();
        String expectEmployeeId = entEmployee.getEmployeeId();

        List expectEmployeeRole = roleAssignmentMapper.getAdminMembers("","");
        assertThat(actualName,equalTo(expectName));
        assertThat(actualEmployeeId,equalTo(expectEmployeeId));
        assertThat(actualEmployeeRoles,containsInAnyOrder(expectEmployeeRole));
    }

//    待完善
    @Parameters({"entCode"})
    @Test(groups = {"web"})
    public void getEmployeeSyncInfo(String entCode){
        Response response = given().contentType("application/json")
                .param("employeeCode", "")
                .header("entCode", entCode).header("tokenId", loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.EMPLOYEE_SYNC_INFO_URL);
        List<EmployeeAppSimpleDto> syncInfo = response.getBody().as(SyncInfoResult.class).getData();
        List actualAppCode = null;
        for(int i=0;i<syncInfo.size();i++){
            String appCode = syncInfo.get(i).getAppCode();
            actualAppCode.add(appCode);
        }


        List expectAppCode = entApplicationInfoMapper.getAppCode("");

        assertThat(actualAppCode,equalTo(expectAppCode));

    }

}


