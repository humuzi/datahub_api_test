package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/9/22
 */
@Data
public class EmployeeAppSimpleDto {
    private String appCode;
    private String appName;
    private String appAccount;
    private boolean canSyncToApp;
}
