package com.datahub.web.dto.responseDto;

import com.datahub.enumeration.FuncPermEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Create by HuQiuYue on 2020/10/10
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuncPermDto {
    private FuncPermEnum type;
    private boolean defaulted;
}
