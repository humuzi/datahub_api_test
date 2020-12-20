package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/10/21
 */
@Data
public class OrderMetadataDto extends OrderMeta {
    
    private String originalOperationId;
    
    private String approvalNo;
    
    private String paidAt;
    
    private String source;
    
    private Boolean onBusiness;
    
    private String currency;
    private String auditStatus;
    private String remark;

    private Boolean isOnline;

    private String incompatibleReason;

    private String approverSourceId;

    private String approverName;

    private String approver2SourceId;

    private String approver2Name;

    private String departmentCode;
    private String subsidiaryCode;
}
