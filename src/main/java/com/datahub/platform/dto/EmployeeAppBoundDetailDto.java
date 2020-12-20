package com.datahub.platform.dto;

import com.datahub.enumeration.AppOpenStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/12/4
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeAppBoundDetailDto {
    private String appCode;
    private String appName;
    private String entCode;
    private String corpCode;
    private AppOpenStatus appOpenStatus;
    private String  displayOpenStatus;
    private List<EntAppConfigItemDto> configItems;
    private String redirectUrl;
    private String appIcon;
    private String corpChannel;
    private String appAccount;
    private boolean bindable;
    private Boolean ssoViaPC;

}
