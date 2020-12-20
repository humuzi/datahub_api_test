package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/7/28
 */
@Data
public class FlightOrderDetailDto extends OrderMetadataDto {

    private float deliveryFee;
    private float insuranceFee;
    private float serviceFee;
    private float extraServiceFee;
    private float changeFee;
    private float changeServiceFee;
    private float refundFee;
    private float refundServiceFee;
    private float deductibleTaxFee;
    private float nonDeductibleTaxFee;
    private List<FlightTicketDto> tickets;
}
