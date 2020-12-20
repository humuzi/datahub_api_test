package com.datahub.platform.dto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/6/10
 */
@Data
public class SubsidiaryInfo {
    private String code;
    private String name;
    private String nameEn;
    private String taxNo;
    private String address;
    private String phone;
    private String bankAccount;
    private String bankBranchName;
    private String businessCode;
    private String parentCode;
    private String parentBusinessCode;
    private String heirCode;
    private String heirName;
    private String heirNameEn;
    private String principalEmployeeCode;
    private List departmentCodes;
    private Integer level;
    private Boolean active;
    private String source;
}
