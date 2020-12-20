package com.datahub.common.dto.resDto;

import com.datahub.web.dto.responseDto.OrderMeta;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/11/19
 */
@Data
public class MealOrderDto extends OrderMeta {
    private String paidAt; //支付时间
    private float originalTotalFee; //原总金额
    private float couponPayFee;//优惠券抵扣金额
    private float deliveryFee;
    private float serviceFee;
    private float refundFee;
    private float personalRefundFee;
    private float corpRefundFee;

    private String dinerAddress; //收货地址
    private String dinerName;
    private String dinerEmployeeId;
    private String dinerPhone;

    private String cityName; //城市名称
    private String cityCode; //城市编码
    private String cityCodePFC; //报销城市编码

    @JsonProperty(value = "restaurantInfo")
    private MealRestaurantDto restaurantDto;

    @JsonProperty(value = "foodInfos")
    private List<MealFoodDto> foodDtos;

    private String remark; //备注

    private String reason; //消费事由
    private float packageFee; //包装费
    private String allowanceName; //餐补名称
    private String dinerCount; //用餐人数
    private String mealTime; //用餐时间

}
