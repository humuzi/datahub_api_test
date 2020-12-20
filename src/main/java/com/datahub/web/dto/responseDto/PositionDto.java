package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/9/27
 */
@Data
public class PositionDto {
    private String code;
    private String businessCode;
    private String name;
    private String comments;
    private String parentCode;
    private String parentBusinessCode;
    private String heirCode;
    private String heirName;
    private int level;
    private boolean active;
    private String source;
}
