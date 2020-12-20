package com.datahub.domain;

import java.util.Date;

public class SubsidiaryInformation {
    private String code;

    private String name;

    private String nameEn;

    private String businessCode;

    private String entCode;

    private String taxNo;

    private String address;

    private String phone;

    private String bankAccount;

    private String bankBranchName;

    private String parentCode;

    private String parentBusinessCode;

    private String heirCode;

    private String heirName;

    private String heirNameEn;

    private String principalEmployeeCode;

    private String source;

    private Byte level;

    private Boolean active;

    private Boolean deleted;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode == null ? null : entCode.trim();
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName == null ? null : bankBranchName.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getParentBusinessCode() {
        return parentBusinessCode;
    }

    public void setParentBusinessCode(String parentBusinessCode) {
        this.parentBusinessCode = parentBusinessCode == null ? null : parentBusinessCode.trim();
    }

    public String getHeirCode() {
        return heirCode;
    }

    public void setHeirCode(String heirCode) {
        this.heirCode = heirCode == null ? null : heirCode.trim();
    }

    public String getHeirName() {
        return heirName;
    }

    public void setHeirName(String heirName) {
        this.heirName = heirName == null ? null : heirName.trim();
    }

    public String getHeirNameEn() {
        return heirNameEn;
    }

    public void setHeirNameEn(String heirNameEn) {
        this.heirNameEn = heirNameEn == null ? null : heirNameEn.trim();
    }

    public String getPrincipalEmployeeCode() {
        return principalEmployeeCode;
    }

    public void setPrincipalEmployeeCode(String principalEmployeeCode) {
        this.principalEmployeeCode = principalEmployeeCode == null ? null : principalEmployeeCode.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }
}