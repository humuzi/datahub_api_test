package com.datahub.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Create by HuQiuYue on 2020/10/26
 */
@Data
public class HotelRoom {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String beginValidateDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String endValidateDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private BigDecimal dailyPrice;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String roomName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String roomNameEn;
}
