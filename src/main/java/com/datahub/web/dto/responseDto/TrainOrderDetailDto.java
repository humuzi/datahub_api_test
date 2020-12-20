package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/8/18
 */
@Data
public class TrainOrderDetailDto extends OrderMetadataDto {
    private float deliveryFee;
    private float insuranceFee;
    private float serviceFee;

    private float changeFee;
    private float changeServiceFee;
    private float refundFee;
    private float refundServiceFee;

    private float deductibleTaxFee;
    private float nonDeductibleTaxFee;
    private List<TrainTicketDto> tickets;
}
