package com.datahub.platform.dto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/12/3
 */
@Data
public class EmployeeAppDetailDto extends EntAppDetailDto {
    private String appAccount;
    private boolean bindable;
    private Boolean ssoViaPC;
}
