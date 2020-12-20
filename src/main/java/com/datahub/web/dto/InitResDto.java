package com.datahub.web.dto;

import com.datahub.web.dto.responseDto.BaseMetaInfoDto;
import com.datahub.web.dto.responseDto.EmployeeDetailRespDto;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * Create by HuQiuYue on 2020/7/9
 */
@Data
public class InitResDto {
    private List<BaseMetaInfoDto> nationalityInfos;

    private List<BaseMetaInfoDto> subsidiaries;

    private List<BaseMetaInfoDto>  departments;

    private List<BaseMetaInfoDto>  positions;

    private List<BaseMetaInfoDto>  ranks;

    private BaseMetaInfoDto  entInfo;

    private EmployeeDetailRespDto employeeInfo;
    private Set<String> funcPerms;
}
