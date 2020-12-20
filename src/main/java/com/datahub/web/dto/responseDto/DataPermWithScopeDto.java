package com.datahub.web.dto.responseDto;

import com.datahub.enumeration.FuncPermEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/10/10
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataPermWithScopeDto {
    private boolean defaulted;
    private String roleCode;
    private String code;
    // "数据权限的类型"
    private DataPermTypeEnum type;
    //  某一个 数据权限类型  可见范围 ，比如 部门的时候 可以选对个部门 且有些部门的
    private List<DataPermWhiteListMetaDto> whiteList;
    private FuncPermEnum funcPerm;
}
