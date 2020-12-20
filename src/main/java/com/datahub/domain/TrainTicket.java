package com.datahub.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TrainTicket {
    private Long id;

    private String entCode;

    private String orderId;

    private String operationId;

    private String trainNo;

    private Date applyChangeAt;

    private Date changedAt;

    private Date refundAt;

    private Date departureAt;

    private String departureCityCode;

    private String departureCityName;

    private String departureStationCode;

    private String departureStationName;

    private Date arrivalAt;

    private String arrivalCityCode;

    private String arrivalCityName;

    private String arrivalStationCode;

    private String arrivalStationName;

    private String departureDhCityCode;

    private String arrivalDhCityCode;

    private String seatClass;

    private BigDecimal ticketFee;

    private BigDecimal insuranceFee;

    private Date createdAt;

    private Date updatedAt;

    private String appCode;

    private BigDecimal ticketServiceFee;

    private String passenger;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode == null ? null : entCode.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId == null ? null : operationId.trim();
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo == null ? null : trainNo.trim();
    }

    public Date getApplyChangeAt() {
        return applyChangeAt;
    }

    public void setApplyChangeAt(Date applyChangeAt) {
        this.applyChangeAt = applyChangeAt;
    }

    public Date getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(Date changedAt) {
        this.changedAt = changedAt;
    }

    public Date getRefundAt() {
        return refundAt;
    }

    public void setRefundAt(Date refundAt) {
        this.refundAt = refundAt;
    }

    public Date getDepartureAt() {
        return departureAt;
    }

    public void setDepartureAt(Date departureAt) {
        this.departureAt = departureAt;
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode == null ? null : departureCityCode.trim();
    }

    public String getDepartureCityName() {
        return departureCityName;
    }

    public void setDepartureCityName(String departureCityName) {
        this.departureCityName = departureCityName == null ? null : departureCityName.trim();
    }

    public String getDepartureStationCode() {
        return departureStationCode;
    }

    public void setDepartureStationCode(String departureStationCode) {
        this.departureStationCode = departureStationCode == null ? null : departureStationCode.trim();
    }

    public String getDepartureStationName() {
        return departureStationName;
    }

    public void setDepartureStationName(String departureStationName) {
        this.departureStationName = departureStationName == null ? null : departureStationName.trim();
    }

    public Date getArrivalAt() {
        return arrivalAt;
    }

    public void setArrivalAt(Date arrivalAt) {
        this.arrivalAt = arrivalAt;
    }

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode == null ? null : arrivalCityCode.trim();
    }

    public String getArrivalCityName() {
        return arrivalCityName;
    }

    public void setArrivalCityName(String arrivalCityName) {
        this.arrivalCityName = arrivalCityName == null ? null : arrivalCityName.trim();
    }

    public String getArrivalStationCode() {
        return arrivalStationCode;
    }

    public void setArrivalStationCode(String arrivalStationCode) {
        this.arrivalStationCode = arrivalStationCode == null ? null : arrivalStationCode.trim();
    }

    public String getArrivalStationName() {
        return arrivalStationName;
    }

    public void setArrivalStationName(String arrivalStationName) {
        this.arrivalStationName = arrivalStationName == null ? null : arrivalStationName.trim();
    }

    public String getDepartureDhCityCode() {
        return departureDhCityCode;
    }

    public void setDepartureDhCityCode(String departureDhCityCode) {
        this.departureDhCityCode = departureDhCityCode == null ? null : departureDhCityCode.trim();
    }

    public String getArrivalDhCityCode() {
        return arrivalDhCityCode;
    }

    public void setArrivalDhCityCode(String arrivalDhCityCode) {
        this.arrivalDhCityCode = arrivalDhCityCode == null ? null : arrivalDhCityCode.trim();
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass == null ? null : seatClass.trim();
    }

    public BigDecimal getTicketFee() {
        return ticketFee;
    }

    public void setTicketFee(BigDecimal ticketFee) {
        this.ticketFee = ticketFee;
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
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

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode == null ? null : appCode.trim();
    }

    public BigDecimal getTicketServiceFee() {
        return ticketServiceFee;
    }

    public void setTicketServiceFee(BigDecimal ticketServiceFee) {
        this.ticketServiceFee = ticketServiceFee;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger == null ? null : passenger.trim();
    }
}