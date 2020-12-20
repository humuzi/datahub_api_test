package com.datahub.mybatis.mapper;

import com.datahub.domain.TrainTicket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainTicketMapper {

    List<TrainTicket> getTrainOrderDetail(@Param("entCode")String entCode, @Param("operationId")String orderId);
}