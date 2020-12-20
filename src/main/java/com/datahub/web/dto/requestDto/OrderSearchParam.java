package com.datahub.web.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Create by HuQiuYue on 2020/7/31
 */
@Data
public class OrderSearchParam {

    private String appCode;
    private List<String> orderTypes;
    private String keyword;
    private String startTime;
    private String endTime;
    private int pageNo;
    private int pageSize;
    private String payTypes;
}
