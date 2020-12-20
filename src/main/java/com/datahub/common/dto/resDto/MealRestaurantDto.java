package com.datahub.common.dto.resDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/11/19
 */
@Data
public class MealRestaurantDto {
    private String name;
    private String phone;
    private String address;
    private String sourceCityCode;
    private String sourceCityName;
    private String cityCode;
}
