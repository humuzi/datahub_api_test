package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/7/24
 */
@Data
public class OrderMeta {

    private String entCode;

    private String appCode;
    private String appName;

    private String orderId;

    private String operationId;

    private String orderedAt;

    private String operatedAt;

    private String orderType;

    private String orderTypeName;

    private float totalFee;

    private float corpPayFee;

    private float personalPayFee;

    private String currency;

    private String payType;

    private String payTypeName;

    private String employeeSourceId;

    private String employeeName;

    private String employeeId;

    private String employeeCode;

    private String externalDepartmentName;

    private String orderStatus;

    private String originalOrderId;

    private String originalOperationId;

    private String briefNotes;
    private boolean manualPull;
}
