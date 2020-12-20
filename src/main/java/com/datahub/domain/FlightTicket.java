package com.datahub.domain;

import java.math.BigDecimal;
import java.util.Date;

public class FlightTicket {
    private Long id;

    private String entCode;

    private String orderId;

    private String operationId;

    private String ticketNo;

    private String ticketNoAc;

    private String originalTicketNo;

    private String sequence;

    private String flightNo;

    private Boolean isInternationalFlight;

    private String aircraftType;

    private String airlineName;

    private String airlineCode;

    private Date applyChangeAt;

    private Date changedAt;

    private Date refundAt;

    private Date departureAt;

    private String departureTimezone;

    private String departureCityCode;

    private String departureCityName;

    private String departurePortCode;

    private String departurePortName;

    private Date arrivalAt;

    private String arrivalTimezone;

    private String arrivalCityCode;

    private String arrivalCityName;

    private String arrivalPortCode;

    private String arrivalPortName;

    private Integer flyDuration;

    private String departureDhCityCode;

    private String arrivalDhCityCode;

    private String cabin;

    private String subCabin;

    private BigDecimal ticketFee;

    private BigDecimal standardTicketFee;

    private Integer discount;

    private BigDecimal insuranceFee;

    private BigDecimal ticketServiceFee;

    private BigDecimal taxFee;

    private BigDecimal oilFee;

    private String currency;

    private String printNo;

    private String printTicketNo;

    private BigDecimal printAmount;

    private String lowFlightNo;

    private String lowCabin;

    private String lowAmount;

    private String lowDiscount;

    private Date createdAt;

    private Date updatedAt;

    private String airlineCabinName;

    private String appCode;

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

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo == null ? null : ticketNo.trim();
    }

    public String getTicketNoAc() {
        return ticketNoAc;
    }

    public void setTicketNoAc(String ticketNoAc) {
        this.ticketNoAc = ticketNoAc == null ? null : ticketNoAc.trim();
    }

    public String getOriginalTicketNo() {
        return originalTicketNo;
    }

    public void setOriginalTicketNo(String originalTicketNo) {
        this.originalTicketNo = originalTicketNo == null ? null : originalTicketNo.trim();
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence == null ? null : sequence.trim();
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo == null ? null : flightNo.trim();
    }

    public Boolean getIsInternationalFlight() {
        return isInternationalFlight;
    }

    public void setIsInternationalFlight(Boolean isInternationalFlight) {
        this.isInternationalFlight = isInternationalFlight;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType == null ? null : aircraftType.trim();
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName == null ? null : airlineName.trim();
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode == null ? null : airlineCode.trim();
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

    public String getDepartureTimezone() {
        return departureTimezone;
    }

    public void setDepartureTimezone(String departureTimezone) {
        this.departureTimezone = departureTimezone == null ? null : departureTimezone.trim();
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

    public String getDeparturePortCode() {
        return departurePortCode;
    }

    public void setDeparturePortCode(String departurePortCode) {
        this.departurePortCode = departurePortCode == null ? null : departurePortCode.trim();
    }

    public String getDeparturePortName() {
        return departurePortName;
    }

    public void setDeparturePortName(String departurePortName) {
        this.departurePortName = departurePortName == null ? null : departurePortName.trim();
    }

    public Date getArrivalAt() {
        return arrivalAt;
    }

    public void setArrivalAt(Date arrivalAt) {
        this.arrivalAt = arrivalAt;
    }

    public String getArrivalTimezone() {
        return arrivalTimezone;
    }

    public void setArrivalTimezone(String arrivalTimezone) {
        this.arrivalTimezone = arrivalTimezone == null ? null : arrivalTimezone.trim();
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

    public String getArrivalPortCode() {
        return arrivalPortCode;
    }

    public void setArrivalPortCode(String arrivalPortCode) {
        this.arrivalPortCode = arrivalPortCode == null ? null : arrivalPortCode.trim();
    }

    public String getArrivalPortName() {
        return arrivalPortName;
    }

    public void setArrivalPortName(String arrivalPortName) {
        this.arrivalPortName = arrivalPortName == null ? null : arrivalPortName.trim();
    }

    public Integer getFlyDuration() {
        return flyDuration;
    }

    public void setFlyDuration(Integer flyDuration) {
        this.flyDuration = flyDuration;
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

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin == null ? null : cabin.trim();
    }

    public String getSubCabin() {
        return subCabin;
    }

    public void setSubCabin(String subCabin) {
        this.subCabin = subCabin == null ? null : subCabin.trim();
    }

    public BigDecimal getTicketFee() {
        return ticketFee;
    }

    public void setTicketFee(BigDecimal ticketFee) {
        this.ticketFee = ticketFee;
    }

    public BigDecimal getStandardTicketFee() {
        return standardTicketFee;
    }

    public void setStandardTicketFee(BigDecimal standardTicketFee) {
        this.standardTicketFee = standardTicketFee;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public BigDecimal getTicketServiceFee() {
        return ticketServiceFee;
    }

    public void setTicketServiceFee(BigDecimal ticketServiceFee) {
        this.ticketServiceFee = ticketServiceFee;
    }

    public BigDecimal getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(BigDecimal taxFee) {
        this.taxFee = taxFee;
    }

    public BigDecimal getOilFee() {
        return oilFee;
    }

    public void setOilFee(BigDecimal oilFee) {
        this.oilFee = oilFee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getPrintNo() {
        return printNo;
    }

    public void setPrintNo(String printNo) {
        this.printNo = printNo == null ? null : printNo.trim();
    }

    public String getPrintTicketNo() {
        return printTicketNo;
    }

    public void setPrintTicketNo(String printTicketNo) {
        this.printTicketNo = printTicketNo == null ? null : printTicketNo.trim();
    }

    public BigDecimal getPrintAmount() {
        return printAmount;
    }

    public void setPrintAmount(BigDecimal printAmount) {
        this.printAmount = printAmount;
    }

    public String getLowFlightNo() {
        return lowFlightNo;
    }

    public void setLowFlightNo(String lowFlightNo) {
        this.lowFlightNo = lowFlightNo == null ? null : lowFlightNo.trim();
    }

    public String getLowCabin() {
        return lowCabin;
    }

    public void setLowCabin(String lowCabin) {
        this.lowCabin = lowCabin == null ? null : lowCabin.trim();
    }

    public String getLowAmount() {
        return lowAmount;
    }

    public void setLowAmount(String lowAmount) {
        this.lowAmount = lowAmount == null ? null : lowAmount.trim();
    }

    public String getLowDiscount() {
        return lowDiscount;
    }

    public void setLowDiscount(String lowDiscount) {
        this.lowDiscount = lowDiscount == null ? null : lowDiscount.trim();
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

    public String getAirlineCabinName() {
        return airlineCabinName;
    }

    public void setAirlineCabinName(String airlineCabinName) {
        this.airlineCabinName = airlineCabinName == null ? null : airlineCabinName.trim();
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode == null ? null : appCode.trim();
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger == null ? null : passenger.trim();
    }
}