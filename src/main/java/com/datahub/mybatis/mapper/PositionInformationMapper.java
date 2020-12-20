package com.datahub.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionInformationMapper {
    List getAllPosition(String entCode);
    List searchPositionByKeyword(@Param("entCode")String entCode,@Param("keyword")String keyword);
}