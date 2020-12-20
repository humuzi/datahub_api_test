package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/8/21
 */
@Data
public class SubsidiaryDto {
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
    private List<String> departmentCodes;
    private List<DepartmentDto> departments;
    private int level;
    private boolean active;
    private String source;
}
