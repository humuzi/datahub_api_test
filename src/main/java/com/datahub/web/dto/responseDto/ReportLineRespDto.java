package com.datahub.web.dto.responseDto;

import lombok.Data;

/**
 * Create by HuQiuYue on 2020/7/23
 */
@Data
public class ReportLineRespDto {
    private BaseMetaInfoDto departmentInfo;
    private BaseMetaInfoDto positionInfo;
    private BaseMetaInfoDto rankInfo;
    private BaseMetaInfoDto supervisorInfo;
}
