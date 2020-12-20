package com.datahub.mybatis.mapper;

import com.datahub.domain.FlightTicket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTicketMapper {
    FlightTicket getFlightTicket(@Param("entCode")String entCode,@Param("appCode")String appCode,@Param("operationId")String operationId);
}