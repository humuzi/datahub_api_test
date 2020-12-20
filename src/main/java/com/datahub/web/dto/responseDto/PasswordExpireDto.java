package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/8/26
 */
@Data
public class PasswordExpireDto {
    private long daysBeforeExpire;
    private Boolean expired;
    private String message;
}
