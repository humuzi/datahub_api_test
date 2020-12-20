package com.datahub.mybatis.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntRoleMapper {
    List getEntAllRoles(String entCode);
}