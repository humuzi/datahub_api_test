package com.datahub.web.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Create by HuQiuYue on 2020/10/13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataPermWhiteListMetaDto {
    
    private String associatedCode;
    private boolean includeChild;
    private String associatedName;
    private DataPermTypeEnum associatedType;
}
