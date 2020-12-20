package com.datahub.mybatis.mapper;

import com.datahub.domain.HotelOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelOrderMapper {
    Long getHotelOrderCount(@Param("entCode")String entCode, @Param("startAt") String startAt, @Param("endAt")String entAt,@Param("manualPull")Boolean manualPull);

    int getHotelOrderByKeyword(@Param("entCode")String entCode,@Param("startAt") String startAt,@Param("endAt")String entAt,@Param("keyword")String keyword,@Param("payTypes")String payTypes);

    HotelOrder getHotelOrder(@Param("entCode")String entCode,@Param("appCode")String appCode,@Param("operationId") String operationId);

}