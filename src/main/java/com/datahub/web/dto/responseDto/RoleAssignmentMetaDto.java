package com.datahub.web.dto.responseDto;

import com.datahub.enumeration.RoleAssignmentTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Create by HuQiuYue on 2020/10/10
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleAssignmentMetaDto {
    private RoleAssignmentTypeEnum assignType;
    
    private String memberCode;
    
    private String memberName;
    
    private boolean includeChild;
}
