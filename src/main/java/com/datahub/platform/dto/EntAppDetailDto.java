package com.datahub.platform.dto;

import java.io.Serializable;
import java.util.List;
import com.datahub.enumeration.AppOpenStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Create by HuQiuYue on 2020/12/3
 */
@Data
@JsonIgnoreProperties
public class EntAppDetailDto implements Serializable {
    private String appCode;
    private String appName;
    private String entCode;
    private String corpCode;
    private AppOpenStatus openStatus;
    private String displayOpenStatus;
    private List<EntAppConfigItemDto> configItems;
}
