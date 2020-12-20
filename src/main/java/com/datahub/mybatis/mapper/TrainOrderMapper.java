package com.datahub.mybatis.mapper;

import com.datahub.domain.TrainOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainOrderMapper {
    long getTrainOrderCount(@Param("entCode")String entCode, @Param("startAt")String startAt, @Param("endAt")String entAt, @Param("manualPull")Boolean manualPull);
    TrainOrder getTrainOrderList(@Param("entCode")String entCode, @Param("operationId")String operationId);
}