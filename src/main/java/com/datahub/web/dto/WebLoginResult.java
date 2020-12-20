package com.datahub.web.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/9/1
 */

@Data
public class WebLoginResult {
    private String redirectUrl;
    private String corpId;
    private String entName;
    private String fromApp;
    private String source;
    private String cdn;
    private String accessToken;
    private String userCode;
    private String employeeCode;
    private String entCode;
    private String apiRoot;
    private String appKey;
    private String lang;
    private String refreshToken;

}
