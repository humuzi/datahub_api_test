package com.datahub.platform.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/12/14
 */
@Data
public class DepartmentInfo {
    private String code;
    private String name;
    private String nameEn;
    private String businessCode;
    private String costCenterCode;
    private String parentCode;
    private String parentBusinessCode;
    private String heirCode;
    private String heirName;
    private String heirNameEn;
    private String principalEmployeeCode;
    private int level;
    private boolean active;
    private List<String> subsidiaryCodes; //部门所属的子公司或者可见的开票子公司
    private String source;
}
