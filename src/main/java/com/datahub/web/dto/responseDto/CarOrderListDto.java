package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/8/6
 */
@Data
public class CarOrderListDto extends OrderMetadataDto{
    private String cityCode;
    private String cityCodePFC;
    private String appCode; //应用编码
    private String orderId; //订单id
    private String cityName; //城市名称

    private String callerPhone;//叫车人手机号
    private String callerName;//叫车人姓名
    private String callerSourceId;//报销人员工编码-外部
    private String passengerPhone;//乘车人手机号
    private String passengerName;//乘车人姓名
    private String passengerSourceId;//报销人员工编码-外部
    private String departureAddress;//出发地地址
    private String arrivalAddress;//目的地地址
    private String carType;
    //用车方式, TAXI:出租车, ECONOMY:经济型, PRIVILEGED:优享型, BUSINESS:商务型, LUXURY:豪华型, DESIGNATED:代驾, PLANESTATION:接送机, TRAINSTATION:接送站'
    private String carTypeSourceName;
    private String payType;//支付方式, CORP_ACCOUNT_PAY:公司支付, PERSONAL_PAY:个人支付, MIXED_PAY:混合支付

    private String departureTime;//出发时间
    private String arrivalTime;//到达时间=结束计价时间
    private String payTime;//支付时间

    private String invoiceDownloadUrl;  // 订单的发票下载地址
    private String itineraryDownloadUrl; // 行程单下载地址

    private float totalDistance;
    private int totalDuration;
}
