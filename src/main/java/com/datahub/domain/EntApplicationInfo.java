package com.datahub.domain;

import java.util.Date;

public class EntApplicationInfo {
    private Long id;

    private String appCode;

    private String entCode;

    private String entName;

    private String corpCode;

    private String corpChannel;

    private String corpKey1;

    private String corpKey2;

    private String adminName;

    private String adminPhone;

    private String adminEmployeeId;

    private String openStatus;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    private String appBusinessScopes;

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

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName == null ? null : entName.trim();
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getCorpChannel() {
        return corpChannel;
    }

    public void setCorpChannel(String corpChannel) {
        this.corpChannel = corpChannel == null ? null : corpChannel.trim();
    }

    public String getCorpKey1() {
        return corpKey1;
    }

    public void setCorpKey1(String corpKey1) {
        this.corpKey1 = corpKey1 == null ? null : corpKey1.trim();
    }

    public String getCorpKey2() {
        return corpKey2;
    }

    public void setCorpKey2(String corpKey2) {
        this.corpKey2 = corpKey2 == null ? null : corpKey2.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    public String getAdminEmployeeId() {
        return adminEmployeeId;
    }

    public void setAdminEmployeeId(String adminEmployeeId) {
        this.adminEmployeeId = adminEmployeeId == null ? null : adminEmployeeId.trim();
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus == null ? null : openStatus.trim();
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

    public String getAppBusinessScopes() {
        return appBusinessScopes;
    }

    public void setAppBusinessScopes(String appBusinessScopes) {
        this.appBusinessScopes = appBusinessScopes == null ? null : appBusinessScopes.trim();
    }
}