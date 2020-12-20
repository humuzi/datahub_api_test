package com.datahub.web.dto.responseDto;

import com.datahub.enumeration.SysRole;
import com.datahub.enumeration.Visibility;
import lombok.Data;

/**
 * Create by HuQiuYue on 2020/7/23
 */
@Data
public class EmployeeRoleForm {
    private String comments;
    private SysRole role;
    private Visibility visibility;
}
