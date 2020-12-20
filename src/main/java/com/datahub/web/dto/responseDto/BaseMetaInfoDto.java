package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/7/23
 */
@Data
public class BaseMetaInfoDto {
    private String code;
    private String name;


    public static BaseMetaInfoDto of(String code, String name) {
        BaseMetaInfoDto result = new BaseMetaInfoDto();
        result.setCode(code);
        result.setName(name);
        return result;

    }
}
