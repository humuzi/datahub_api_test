package com.datahub.domain;

import java.math.BigDecimal;
import java.util.Date;

public class FlightOrder {
    private Long id;

    private String appCode;

    private String entCode;

    private String corpCode;

    private String corpAccountCode;

    private String orderId;

    private String originalOrderId;

    private String operationId;

    private String originalOperationId;

    private String approvalNo;

    private String externalApprovalNo;

    private String employeeCode;

    private String externalEmployeeCode;

    private String employeeSourceId;

    private String employeeId;

    private String employeeName;

    private String externalEmployeeName;

    private Date orderedAt;

    private Date operatedAt;

    private Date paidAt;

    private String incompatibleReason;

    private String approverEmployeeCode;

    private String approverSourceId;

    private String approverName;

    private String approver2EmployeeCode;

    private String approver2SourceId;

    private String approver2Name;

    private String remark;

    private String orderStatus;

    private String auditStatus;

    private Boolean businessPurpose;

    private String payType;

    private BigDecimal totalFee;

    private BigDecimal corpPayFee;

    private BigDecimal personalPayFee;

    private BigDecimal deliveryFee;

    private BigDecimal insuranceFee;

    private BigDecimal deductibleTaxFee;

    private BigDecimal nonDeductibleTaxFee;

    private BigDecimal extraServiceFee;

    private BigDecimal changeFee;

    private BigDecimal changeServiceFee;

    private BigDecimal refundFee;

    private BigDecimal refundServiceFee;

    private String currency;

    private String isOnline;

    private String subsidiaryCode;

    private String departmentCode;

    private String preConsumeCode;

    private String preConsumeDataCode;

    private String preConsumeStatus;

    private String corpFeeCode;

    private String corpReimburseCode;

    private String corpReimburseDataCode;

    private String corpReimburseStatus;

    private String corpSettledStatus;

    private Date corpSettledAt;

    private String personalFeeCode;

    private String personalReimburseCode;

    private String personalReimburseDataCode;

    private String personalReimburseStatus;

    private String personalSettledStatus;

    private Date personalSettledAt;

    private String reconcileBillCode;

    private String orderPrintNo;

    private String orderPrintTicketNo;

    private BigDecimal orderPrintAmount;

    private String settlementBatchNo;

    private String subSettlementBatchNo;

    private String paymentBatchNo;

    private BigDecimal serviceFee;

    private Date createdAt;

    private Date updatedAt;

    private String orderType;

    private String externalDepartmentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode == null ? null : appCode.trim();
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode == null ? null : entCode.trim();
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getCorpAccountCode() {
        return corpAccountCode;
    }

    public void setCorpAccountCode(String corpAccountCode) {
        this.corpAccountCode = corpAccountCode == null ? null : corpAccountCode.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(String originalOrderId) {
        this.originalOrderId = originalOrderId == null ? null : originalOrderId.trim();
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId == null ? null : operationId.trim();
    }

    public String getOriginalOperationId() {
        return originalOperationId;
    }

    public void setOriginalOperationId(String originalOperationId) {
        this.originalOperationId = originalOperationId == null ? null : originalOperationId.trim();
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo == null ? null : approvalNo.trim();
    }

    public String getExternalApprovalNo() {
        return externalApprovalNo;
    }

    public void setExternalApprovalNo(String externalApprovalNo) {
        this.externalApprovalNo = externalApprovalNo == null ? null : externalApprovalNo.trim();
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    public String getExternalEmployeeCode() {
        return externalEmployeeCode;
    }

    public void setExternalEmployeeCode(String externalEmployeeCode) {
        this.externalEmployeeCode = externalEmployeeCode == null ? null : externalEmployeeCode.trim();
    }

    public String getEmployeeSourceId() {
        return employeeSourceId;
    }

    public void setEmployeeSourceId(String employeeSourceId) {
        this.employeeSourceId = employeeSourceId == null ? null : employeeSourceId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getExternalEmployeeName() {
        return externalEmployeeName;
    }

    public void setExternalEmployeeName(String externalEmployeeName) {
        this.externalEmployeeName = externalEmployeeName == null ? null : externalEmployeeName.trim();
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Date getOperatedAt() {
        return operatedAt;
    }

    public void setOperatedAt(Date operatedAt) {
        this.operatedAt = operatedAt;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public String getIncompatibleReason() {
        return incompatibleReason;
    }

    public void setIncompatibleReason(String incompatibleReason) {
        this.incompatibleReason = incompatibleReason == null ? null : incompatibleReason.trim();
    }

    public String getApproverEmployeeCode() {
        return approverEmployeeCode;
    }

    public void setApproverEmployeeCode(String approverEmployeeCode) {
        this.approverEmployeeCode = approverEmployeeCode == null ? null : approverEmployeeCode.trim();
    }

    public String getApproverSourceId() {
        return approverSourceId;
    }

    public void setApproverSourceId(String approverSourceId) {
        this.approverSourceId = approverSourceId == null ? null : approverSourceId.trim();
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName == null ? null : approverName.trim();
    }

    public String getApprover2EmployeeCode() {
        return approver2EmployeeCode;
    }

    public void setApprover2EmployeeCode(String approver2EmployeeCode) {
        this.approver2EmployeeCode = approver2EmployeeCode == null ? null : approver2EmployeeCode.trim();
    }

    public String getApprover2SourceId() {
        return approver2SourceId;
    }

    public void setApprover2SourceId(String approver2SourceId) {
        this.approver2SourceId = approver2SourceId == null ? null : approver2SourceId.trim();
    }

    public String getApprover2Name() {
        return approver2Name;
    }

    public void setApprover2Name(String approver2Name) {
        this.approver2Name = approver2Name == null ? null : approver2Name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public Boolean getBusinessPurpose() {
        return businessPurpose;
    }

    public void setBusinessPurpose(Boolean businessPurpose) {
        this.businessPurpose = businessPurpose;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getCorpPayFee() {
        return corpPayFee;
    }

    public void setCorpPayFee(BigDecimal corpPayFee) {
        this.corpPayFee = corpPayFee;
    }

    public BigDecimal getPersonalPayFee() {
        return personalPayFee;
    }

    public void setPersonalPayFee(BigDecimal personalPayFee) {
        this.personalPayFee = personalPayFee;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public BigDecimal getDeductibleTaxFee() {
        return deductibleTaxFee;
    }

    public void setDeductibleTaxFee(BigDecimal deductibleTaxFee) {
        this.deductibleTaxFee = deductibleTaxFee;
    }

    public BigDecimal getNonDeductibleTaxFee() {
        return nonDeductibleTaxFee;
    }

    public void setNonDeductibleTaxFee(BigDecimal nonDeductibleTaxFee) {
        this.nonDeductibleTaxFee = nonDeductibleTaxFee;
    }

    public BigDecimal getExtraServiceFee() {
        return extraServiceFee;
    }

    public void setExtraServiceFee(BigDecimal extraServiceFee) {
        this.extraServiceFee = extraServiceFee;
    }

    public BigDecimal getChangeFee() {
        return changeFee;
    }

    public void setChangeFee(BigDecimal changeFee) {
        this.changeFee = changeFee;
    }

    public BigDecimal getChangeServiceFee() {
        return changeServiceFee;
    }

    public void setChangeServiceFee(BigDecimal changeServiceFee) {
        this.changeServiceFee = changeServiceFee;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public BigDecimal getRefundServiceFee() {
        return refundServiceFee;
    }

    public void setRefundServiceFee(BigDecimal refundServiceFee) {
        this.refundServiceFee = refundServiceFee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline == null ? null : isOnline.trim();
    }

    public String getSubsidiaryCode() {
        return subsidiaryCode;
    }

    public void setSubsidiaryCode(String subsidiaryCode) {
        this.subsidiaryCode = subsidiaryCode == null ? null : subsidiaryCode.trim();
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    public String getPreConsumeCode() {
        return preConsumeCode;
    }

    public void setPreConsumeCode(String preConsumeCode) {
        this.preConsumeCode = preConsumeCode == null ? null : preConsumeCode.trim();
    }

    public String getPreConsumeDataCode() {
        return preConsumeDataCode;
    }

    public void setPreConsumeDataCode(String preConsumeDataCode) {
        this.preConsumeDataCode = preConsumeDataCode == null ? null : preConsumeDataCode.trim();
    }

    public String getPreConsumeStatus() {
        return preConsumeStatus;
    }

    public void setPreConsumeStatus(String preConsumeStatus) {
        this.preConsumeStatus = preConsumeStatus == null ? null : preConsumeStatus.trim();
    }

    public String getCorpFeeCode() {
        return corpFeeCode;
    }

    public void setCorpFeeCode(String corpFeeCode) {
        this.corpFeeCode = corpFeeCode == null ? null : corpFeeCode.trim();
    }

    public String getCorpReimburseCode() {
        return corpReimburseCode;
    }

    public void setCorpReimburseCode(String corpReimburseCode) {
        this.corpReimburseCode = corpReimburseCode == null ? null : corpReimburseCode.trim();
    }

    public String getCorpReimburseDataCode() {
        return corpReimburseDataCode;
    }

    public void setCorpReimburseDataCode(String corpReimburseDataCode) {
        this.corpReimburseDataCode = corpReimburseDataCode == null ? null : corpReimburseDataCode.trim();
    }

    public String getCorpReimburseStatus() {
        return corpReimburseStatus;
    }

    public void setCorpReimburseStatus(String corpReimburseStatus) {
        this.corpReimburseStatus = corpReimburseStatus == null ? null : corpReimburseStatus.trim();
    }

    public String getCorpSettledStatus() {
        return corpSettledStatus;
    }

    public void setCorpSettledStatus(String corpSettledStatus) {
        this.corpSettledStatus = corpSettledStatus == null ? null : corpSettledStatus.trim();
    }

    public Date getCorpSettledAt() {
        return corpSettledAt;
    }

    public void setCorpSettledAt(Date corpSettledAt) {
        this.corpSettledAt = corpSettledAt;
    }

    public String getPersonalFeeCode() {
        return personalFeeCode;
    }

    public void setPersonalFeeCode(String personalFeeCode) {
        this.personalFeeCode = personalFeeCode == null ? null : personalFeeCode.trim();
    }

    public String getPersonalReimburseCode() {
        return personalReimburseCode;
    }

    public void setPersonalReimburseCode(String personalReimburseCode) {
        this.personalReimburseCode = personalReimburseCode == null ? null : personalReimburseCode.trim();
    }

    public String getPersonalReimburseDataCode() {
        return personalReimburseDataCode;
    }

    public void setPersonalReimburseDataCode(String personalReimburseDataCode) {
        this.personalReimburseDataCode = personalReimburseDataCode == null ? null : personalReimburseDataCode.trim();
    }

    public String getPersonalReimburseStatus() {
        return personalReimburseStatus;
    }

    public void setPersonalReimburseStatus(String personalReimburseStatus) {
        this.personalReimburseStatus = personalReimburseStatus == null ? null : personalReimburseStatus.trim();
    }

    public String getPersonalSettledStatus() {
        return personalSettledStatus;
    }

    public void setPersonalSettledStatus(String personalSettledStatus) {
        this.personalSettledStatus = personalSettledStatus == null ? null : personalSettledStatus.trim();
    }

    public Date getPersonalSettledAt() {
        return personalSettledAt;
    }

    public void setPersonalSettledAt(Date personalSettledAt) {
        this.personalSettledAt = personalSettledAt;
    }

    public String getReconcileBillCode() {
        return reconcileBillCode;
    }

    public void setReconcileBillCode(String reconcileBillCode) {
        this.reconcileBillCode = reconcileBillCode == null ? null : reconcileBillCode.trim();
    }

    public String getOrderPrintNo() {
        return orderPrintNo;
    }

    public void setOrderPrintNo(String orderPrintNo) {
        this.orderPrintNo = orderPrintNo == null ? null : orderPrintNo.trim();
    }

    public String getOrderPrintTicketNo() {
        return orderPrintTicketNo;
    }

    public void setOrderPrintTicketNo(String orderPrintTicketNo) {
        this.orderPrintTicketNo = orderPrintTicketNo == null ? null : orderPrintTicketNo.trim();
    }

    public BigDecimal getOrderPrintAmount() {
        return orderPrintAmount;
    }

    public void setOrderPrintAmount(BigDecimal orderPrintAmount) {
        this.orderPrintAmount = orderPrintAmount;
    }

    public String getSettlementBatchNo() {
        return settlementBatchNo;
    }

    public void setSettlementBatchNo(String settlementBatchNo) {
        this.settlementBatchNo = settlementBatchNo == null ? null : settlementBatchNo.trim();
    }

    public String getSubSettlementBatchNo() {
        return subSettlementBatchNo;
    }

    public void setSubSettlementBatchNo(String subSettlementBatchNo) {
        this.subSettlementBatchNo = subSettlementBatchNo == null ? null : subSettlementBatchNo.trim();
    }

    public String getPaymentBatchNo() {
        return paymentBatchNo;
    }

    public void setPaymentBatchNo(String paymentBatchNo) {
        this.paymentBatchNo = paymentBatchNo == null ? null : paymentBatchNo.trim();
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getExternalDepartmentName() {
        return externalDepartmentName;
    }

    public void setExternalDepartmentName(String externalDepartmentName) {
        this.externalDepartmentName = externalDepartmentName == null ? null : externalDepartmentName.trim();
    }
}