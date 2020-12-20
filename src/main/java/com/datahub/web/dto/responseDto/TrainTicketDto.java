package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/8/17
 */
@Data
public class TrainTicketDto {
    private String entCode;
    private String arrivalAt;
    private String seatClass;
    private String seatClassName;
    private float totalPayFee;
    private float ticketFee;
    private float insuranceFee;
    private float ticketServiceFee;
    private String currency = "CNY";  // 方便前端处理，目前没有任何意义

    private String applyChangeAt;
    private String changedAt;
    private String refundAt;

    private String trainNo;
    private String departureAt;
    private String passengerName;
    private String passageEmployeeId;
    private String arrivalCityName;
    private String departureCityName;
    private String arrivalCityCodePFC;
    private String departureCityCodePFC;
    private String departureStationCode;
    private String arrivalStationName;
    private String departureStationName;
}
