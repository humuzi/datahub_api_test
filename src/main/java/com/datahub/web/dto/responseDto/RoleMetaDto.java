package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/9/27
 */
@Data
public class RoleMetaDto {
    private String code;
    private String name;
    private Boolean defaulted;
    private String remark;
}
