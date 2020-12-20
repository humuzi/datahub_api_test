package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/7/28
 */
@Data
public class FlightTicketDto {
    private String ticketNo;
    private String ticketNoAc;
    private String originalTicketNo;
    private String sequence;
    private String flightNo;
    private String flightType;

    private String airlineName;
    private String airlineCode;
    private String aircraftType;

    private String passengerSourceId;
    private String passengerEmployeeId;
    private String passengerName;

    private String applyChangeAt;
    private String changedAt;
    private String refundAt;

    private String departureAt;
    private String departureTimezone;
    private String departureCityCode;
    private String departureCityName;
    private String departurePortCode;
    private String departurePortName;

    private String arrivalAt;
    private String arrivalTimezone;
    private String arrivalCityCode;
    private String arrivalCityName;
    private String arrivalPortCode;
    private String arrivalPortName;

    private String departureCityCodePFC;
    private String arrivalCityCodePFC;

    private Integer flyDuration;

    private String cabin;
    private String cabinName;
    private String subCabin;

    private float totalPayFee;  // ticketFee + insuranceFee + ticketServiceFee + taxFee + oilFee
    private float ticketFee;  // 折后价
    private float standardTicketFee;  // 票原价
    private Integer discount;
    private float insuranceFee;
    private float ticketServiceFee;
    private float taxFee;
    private float oilFee;
    private String currency;

    private String printNo;
    private String printTicketNo;
    private float printAmount;

    private String lowFlightNo;
    private String lowCabin;
    private float lowAmount;
    private Integer lowDiscount;
}
