package com.datahub.mybatis.mapper;

import com.datahub.domain.CarOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOrderMapper {
    Long getCarOrderCount(@Param("entCode") String entCode, @Param("startAt") String startAt, @Param("endAt") String endAt,@Param("manualPull")Boolean manualPull);

    CarOrder getCarOrder(@Param("entCode") String entCode,@Param("operationId") String operationId);
}