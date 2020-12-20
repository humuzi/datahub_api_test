package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/9/27
 */
@Data
public class RankDto {
    private String code;
    private String name;
    private String comments;
    private String businessCode;
    private String source;
    private boolean active;
}
