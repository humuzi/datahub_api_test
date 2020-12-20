package com.datahub.web.steps;

import com.datahub.common.constant.Constant;
import com.datahub.common.util.ConfigUtil;
import com.datahub.mybatis.mapper.EntRoleMapper;
import com.datahub.mybatis.mapper.RoleAssignmentMapper;
import com.datahub.web.dto.RoleDetailResult;
import com.datahub.web.dto.RoleResult;
import com.datahub.web.dto.responseDto.RoleAssignmentMetaDto;
import com.datahub.web.dto.responseDto.RoleDetailDto;
import com.datahub.web.dto.responseDto.RoleMetaDto;
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
 * Create by HuQiuYue on 2020/9/27
 */
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RoleAndPermissionStepDef extends AbstractTestNGSpringContextTests {

    @Autowired private WebLoginUser loginUser;
    @Autowired private EntRoleMapper entRoleMapper;
    @Autowired private RoleAssignmentMapper roleAssignmentMapper;


     @Parameters({"entCode"})
     @Test(groups = {"web"})
    public void getAllRoles(String entCode){
        Response response = given().accept("application/json")
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.GET_ALL_ROLE_URL);

        List<RoleMetaDto> roleResult = response.getBody().as(RoleResult.class).getData();
        List actualRoleNames = null;
        for(RoleMetaDto roleMetaDto:roleResult){
            actualRoleNames.add(roleMetaDto.getName());
        }

        List expectedRoleNames = entRoleMapper.getEntAllRoles("");

        assertThat(response.statusCode(),equalTo(200));
        assertThat(actualRoleNames,containsInAnyOrder(expectedRoleNames));
    }


     @Parameters({"entCode"})
     @Test(groups = {"web"})
    public void getRoleDetails(String entCode){
        Response response = given().accept("application/json")
                .param("code",entCode + "SYSTEM_ADMIN")
                .header("entCode",entCode).header("tokenId",loginUser.getTokenId())
                .get(ConfigUtil.getWebBaseUrl() + Constant.GET_ROLE_DETAIL_URL);

        RoleDetailDto roleDetail = response.getBody().as(RoleDetailResult.class).getData();
        List  actualAdminMembers = null;
        for(RoleAssignmentMetaDto member: roleDetail.getMembers()){
            actualAdminMembers.add(member.getMemberName());
        }

        List expectedAdminMembers = roleAssignmentMapper.getAdminMembers("","EC20070712E60XKWSYSTEM_ADMIN");
        assertThat(actualAdminMembers,containsInAnyOrder(expectedAdminMembers));
    }
}
