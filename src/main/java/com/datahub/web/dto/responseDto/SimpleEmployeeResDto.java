package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/9/9
 */
@Data
public class SimpleEmployeeResDto extends EmployeePersonDto {
    private String employeeId;
    private String name;
    private String accountCode;
    private String employeeCode;
    private boolean active;
    private String defaultSubsidiaryCode;
    private String defaultSubsidiaryName;
    private String departmentNames;
}
