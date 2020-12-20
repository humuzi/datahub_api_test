package com.datahub.enumeration;

import lombok.Getter;

import java.util.List;


/**
 * Create by HuQiuYue on 2020/10/10
 */
@Getter
public enum RoleTypeEnum {
    // 所有权限
    SYSTEM_ADMIN, //  功能权限为个人设置和订单管理 /数据权限为仅个人订单
    STAFF,
    OTHER,;

    private String code;
    private String name;
    private boolean defaulted;
    private List<FuncPermEnum> defaultFuncPermEnums;
}
