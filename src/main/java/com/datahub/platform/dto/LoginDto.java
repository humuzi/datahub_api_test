package com.datahub.platform.dto;

import lombok.Data;

import java.util.Date;

/**
 * Create by HuQiuYue on 2020/6/5
 */
@Data
public class LoginDto {
    private String entCode;
    private String tokenId;
    private Date expireDate;
}
