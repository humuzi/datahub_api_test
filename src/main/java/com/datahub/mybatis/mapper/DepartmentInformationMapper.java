package com.datahub.mybatis.mapper;

import com.datahub.domain.DepartmentInformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentInformationMapper {

    DepartmentInformation getFirstDepartmentInformation(String entCode);
    List getSubDepartmentCode(@Param("entCode")String entCode, @Param("parentDepartmentCode")String parentDepartmentCode);
    DepartmentInformation searchDepartmentByName(@Param("entCode")String entCode, @Param("keyword")String keyword);
    DepartmentInformation getDepartmentInfo(@Param("entCode")String entCode, @Param("businessCode")String businessCode);
    List<String> getDepartmentCodes(String entCode);

}