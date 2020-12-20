package com.datahub.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleAssignmentMapper {
    List getAdminMembers(@Param("entCode")String entCode,@Param("roleCode")String roleCode);
}