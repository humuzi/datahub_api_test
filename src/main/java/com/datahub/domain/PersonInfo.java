package com.datahub.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Create by HuQiuYue on 2020/10/26
 */
@Data
public class PersonInfo {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String employeeName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String employeeId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String employeeCode;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String employeeSourceId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String externalEmployeeCode;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String externalEmployeeName;
}
