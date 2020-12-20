package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Create by HuQiuYue on 2020/10/22
 */
@Data
public class HotelRoom {
    private String beginValidateDate;
    private String endValidateDate;
    private BigDecimal dailyPrice;
    private String roomName;
    private String roomNameEn;
}
