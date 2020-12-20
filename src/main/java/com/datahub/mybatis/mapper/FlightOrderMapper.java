package com.datahub.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightOrderMapper {

    Long getFlightCount(@Param("entCode") String entCode, @Param("startAt") String startAt, @Param("endAt") String endAt,@Param("manualPull")Boolean manualPull);



}