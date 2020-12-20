package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/7/28
 */
@Data
public class FlightOrderDto extends OrderMeta {
    private float serviceFee;
    private float deliveryFee;
    private float insuranceFee;

    private float changeFee;
    private float changeServiceFee;
    private float refundFee;
    private float refundServiceFee;

    private List<FlightTicketDto> tickets;
}
