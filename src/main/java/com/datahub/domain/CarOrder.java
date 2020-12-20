package com.datahub.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CarOrder {
    private String orderId;

    private String entCode;

    private String appCode;

    private String cityName;

    private String cityCode;

    private String placeCode;

    private Byte orderType;

    private String departureLat;

    private String departureLng;

    private String arrivalLat;

    private String arrivalLng;

    private Date orderedAt;

    private Date useTime;

    private String callerPhone;

    private String callerName;

    private String departureAddress;

    private String arrivalAddress;

    private Date departureTime;

    private Date arrivalTime;

    private Date beginChargeTime;

    private String carType;

    private String payType;

    private String orderStatus;

    private Date payTime;

    private BigDecimal totalDistance;

    private Integer totalDuration;

    private BigDecimal totalPrice;

    private String currency;

    private BigDecimal actualPrice;

    private BigDecimal couponPay;

    private BigDecimal refundPrice;

    private BigDecimal corpPay;

    private BigDecimal personalPay;

    private BigDecimal corpRealPay;

    private BigDecimal personalRealPay;

    private BigDecimal corpRealRefund;

    private BigDecimal personalRealRefund;

    private String orderDetail;

    private String remark;

    private String costCenterId;

    private String ruleId;

    private Byte applyInvoiceCount;

    private String invoiceStatus;

    private String invoiceId;

    private String approvalId;

    private String preFeeCode;

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

    private Date corpSettledTime;

    private String personalFeeCode;

    private String personalReimburseCode;

    private String personalReimburseDataCode;

    private String personalReimburseStatus;

    private String personalSettledStatus;

    private Date personalSettledTime;

    private Date createdAt;

    private Date updatedAt;

    private String reconcileBillCode;

    private String callerEmployeeCode;

    private String callerSourceId;

    private String carTypeSourceName;

    private String carTypeSourceNameEn;

    private String settlementBatchNo;

    private String subSettlementBatchNo;

    private String callerExternalEmployeeCode;

    private String passenger;

    private Boolean isManualPull;

//    private String briefNotes;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode == null ? null : entCode.trim();
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode == null ? null : appCode.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode == null ? null : placeCode.trim();
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public String getDepartureLat() {
        return departureLat;
    }

    public void setDepartureLat(String departureLat) {
        this.departureLat = departureLat == null ? null : departureLat.trim();
    }

    public String getDepartureLng() {
        return departureLng;
    }

    public void setDepartureLng(String departureLng) {
        this.departureLng = departureLng == null ? null : departureLng.trim();
    }

    public String getArrivalLat() {
        return arrivalLat;
    }

    public void setArrivalLat(String arrivalLat) {
        this.arrivalLat = arrivalLat == null ? null : arrivalLat.trim();
    }

    public String getArrivalLng() {
        return arrivalLng;
    }

    public void setArrivalLng(String arrivalLng) {
        this.arrivalLng = arrivalLng == null ? null : arrivalLng.trim();
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public String getCallerPhone() {
        return callerPhone;
    }

    public void setCallerPhone(String callerPhone) {
        this.callerPhone = callerPhone == null ? null : callerPhone.trim();
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName == null ? null : callerName.trim();
    }

    public String getDepartureAddress() {
        return departureAddress;
    }

    public void setDepartureAddress(String departureAddress) {
        this.departureAddress = departureAddress == null ? null : departureAddress.trim();
    }

    public String getArrivalAddress() {
        return arrivalAddress;
    }

    public void setArrivalAddress(String arrivalAddress) {
        this.arrivalAddress = arrivalAddress == null ? null : arrivalAddress.trim();
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getBeginChargeTime() {
        return beginChargeTime;
    }

    public void setBeginChargeTime(Date beginChargeTime) {
        this.beginChargeTime = beginChargeTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(BigDecimal totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Integer getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Integer totalDuration) {
        this.totalDuration = totalDuration;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getCouponPay() {
        return couponPay;
    }

    public void setCouponPay(BigDecimal couponPay) {
        this.couponPay = couponPay;
    }

    public BigDecimal getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
    }

    public BigDecimal getCorpPay() {
        return corpPay;
    }

    public void setCorpPay(BigDecimal corpPay) {
        this.corpPay = corpPay;
    }

    public BigDecimal getPersonalPay() {
        return personalPay;
    }

    public void setPersonalPay(BigDecimal personalPay) {
        this.personalPay = personalPay;
    }

    public BigDecimal getCorpRealPay() {
        return corpRealPay;
    }

    public void setCorpRealPay(BigDecimal corpRealPay) {
        this.corpRealPay = corpRealPay;
    }

    public BigDecimal getPersonalRealPay() {
        return personalRealPay;
    }

    public void setPersonalRealPay(BigDecimal personalRealPay) {
        this.personalRealPay = personalRealPay;
    }

    public BigDecimal getCorpRealRefund() {
        return corpRealRefund;
    }

    public void setCorpRealRefund(BigDecimal corpRealRefund) {
        this.corpRealRefund = corpRealRefund;
    }

    public BigDecimal getPersonalRealRefund() {
        return personalRealRefund;
    }

    public void setPersonalRealRefund(BigDecimal personalRealRefund) {
        this.personalRealRefund = personalRealRefund;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail == null ? null : orderDetail.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(String costCenterId) {
        this.costCenterId = costCenterId == null ? null : costCenterId.trim();
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    public Byte getApplyInvoiceCount() {
        return applyInvoiceCount;
    }

    public void setApplyInvoiceCount(Byte applyInvoiceCount) {
        this.applyInvoiceCount = applyInvoiceCount;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus == null ? null : invoiceStatus.trim();
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId == null ? null : invoiceId.trim();
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId == null ? null : approvalId.trim();
    }

    public String getPreFeeCode() {
        return preFeeCode;
    }

    public void setPreFeeCode(String preFeeCode) {
        this.preFeeCode = preFeeCode == null ? null : preFeeCode.trim();
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

    public Date getCorpSettledTime() {
        return corpSettledTime;
    }

    public void setCorpSettledTime(Date corpSettledTime) {
        this.corpSettledTime = corpSettledTime;
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

    public Date getPersonalSettledTime() {
        return personalSettledTime;
    }

    public void setPersonalSettledTime(Date personalSettledTime) {
        this.personalSettledTime = personalSettledTime;
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

    public String getReconcileBillCode() {
        return reconcileBillCode;
    }

    public void setReconcileBillCode(String reconcileBillCode) {
        this.reconcileBillCode = reconcileBillCode == null ? null : reconcileBillCode.trim();
    }

    public String getCallerEmployeeCode() {
        return callerEmployeeCode;
    }

    public void setCallerEmployeeCode(String callerEmployeeCode) {
        this.callerEmployeeCode = callerEmployeeCode == null ? null : callerEmployeeCode.trim();
    }

    public String getCallerSourceId() {
        return callerSourceId;
    }

    public void setCallerSourceId(String callerSourceId) {
        this.callerSourceId = callerSourceId == null ? null : callerSourceId.trim();
    }

    public String getCarTypeSourceName() {
        return carTypeSourceName;
    }

    public void setCarTypeSourceName(String carTypeSourceName) {
        this.carTypeSourceName = carTypeSourceName == null ? null : carTypeSourceName.trim();
    }

    public String getCarTypeSourceNameEn() {
        return carTypeSourceNameEn;
    }

    public void setCarTypeSourceNameEn(String carTypeSourceNameEn) {
        this.carTypeSourceNameEn = carTypeSourceNameEn == null ? null : carTypeSourceNameEn.trim();
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

    public String getCallerExternalEmployeeCode() {
        return callerExternalEmployeeCode;
    }

    public void setCallerExternalEmployeeCode(String callerExternalEmployeeCode) {
        this.callerExternalEmployeeCode = callerExternalEmployeeCode == null ? null : callerExternalEmployeeCode.trim();
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger == null ? null : passenger.trim();
    }

    public Boolean getIsManualPull() {
        return isManualPull;
    }

    public void setIsManualPull(Boolean isManualPull) {
        this.isManualPull = isManualPull;
    }

}