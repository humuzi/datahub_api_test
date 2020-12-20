package com.datahub.platform.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Create by HuQiuYue on 2020/12/3
 */
@Data
public class EntAppConfigItemDto implements Serializable {
    private String itemCode;
    private String name;
    private String remark;
    private String itemType;
    private List<OptionDto> itemOptions;
    private int itemVal;
    private String groupTag;
}
