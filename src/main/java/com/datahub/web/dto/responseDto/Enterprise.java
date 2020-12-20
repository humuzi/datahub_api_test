package com.datahub.web.dto.responseDto;

import lombok.Data;

import java.util.Date;

/**
 * Create by HuQiuYue on 2020/8/20
 */
@Data
public class Enterprise {
    private String code;
    private String name;
    private String description;
    private boolean active;
    private String tags;
    private String category;
    private String industry;
    private String abbreviation;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String source;
    private String sourceId;
    private String cluster;
    private String callbackUrl;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
}
