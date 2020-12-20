package com.datahub.mybatis.mapper;

import com.datahub.domain.EntEmployee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntEmployeeMapper {

    Long getEmployeeCount(String entCode);

    EntEmployee getEmployeeList(String entCode);

    String getEmployeeCode(@Param("entCode")String entCode,@Param("employeeSourceId")String employeeSourceId);

    EntEmployee getEmployeeDetail(@Param("entCode")String entCode,@Param("employeeCode")String employeeCode);

}