package com.datahub.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntApplicationUserMapper {
   List getAppCode(@Param("entCode")String entCode,@Param("employeeCode")String employeeCode);
   int getSyncCount(@Param("entCode")String entCode,@Param("employeeName")String employeeName);
}