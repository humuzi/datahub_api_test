package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/8/21
 */
@Data
public class DepartmentDto {
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
    private String source;
    private List<String> subsidiaryCodes;
    private List<SubsidiaryDto> subsidiaries;
}
