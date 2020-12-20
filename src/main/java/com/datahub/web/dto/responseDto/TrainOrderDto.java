package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/8/17
 */
@Data
public class TrainOrderDto extends OrderMeta {
    private float serviceFee;
    private float deliveryFee;
    private float insuranceFee;

    private float changeFee;
    private float changeServiceFee;
    private float refundFee;
    private float refundServiceFee;

    private List<TrainTicketDto> tickets;
}
