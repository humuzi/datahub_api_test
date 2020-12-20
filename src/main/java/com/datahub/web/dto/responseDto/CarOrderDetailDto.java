package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/8/13
 */
@Data
public class CarOrderDetailDto extends OrderMetadataDto {
    private String payTime;
    private String cityName;
    private String cityCode;
    private String departureTime;
    private String arrivalTime;
    private int totalDuration;
    private float totalRefund;
    private float personalRefund;
    private float corpRefund;
    private float totalDistance;

    private String carType;
    private String carTypeSourceName;
    private String departureAddress;
    private String arrivalAddress;
    private String callerPhone;
    private String callerName;
    private String callerEmployeeCode;
    private String callerEmployeeId;
    private String subsidiaryName;
    private String departmentName;

    private String passengerPhone;
    private String passengerName;
    private String passengerEmployeeCode;
    private String passengerEmployeeId;
    private String passengerSubsidiaryCode;
    private String passengerSubsidiaryName;
    private String regulationId;//用车规则id
}
