package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Create by HuQiuYue on 2020/7/23
 */
@Data
public class EmployeeDetailRespDto extends EmployeePersonDto implements Serializable {
    private String accountCode;
    private String employeeCode;
    private String name;
    private String employeeId;
    private String source;
    private String sourceId;
    private long businessPrivilege;
    private String defaultSubsidiaryBusinessCode;
    private List<ReportLineRespDto> reportingLines;
    private List<RoleMetaDto> employeeRoles;
    private String custField1;
    private String custField2;
    private String custField3;
    private String custField4;
    private String custField5;
    private String custField6;
    private String custField7;
    private String custField8;
    private String custField9;
    private String custField10;
    private Map<String, String> custProps;
    private boolean active;

}
