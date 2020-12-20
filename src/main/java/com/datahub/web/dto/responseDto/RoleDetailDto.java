package com.datahub.web.dto.responseDto;

import com.datahub.enumeration.RoleTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * Create by HuQiuYue on 2020/10/10
 */
@Data
public class RoleDetailDto extends RoleMetaDto  {
    private RoleTypeEnum type;
    private boolean defaulted;
    private List<DataPermWithScopeDto> dataPermWithScopes;
    private List<FuncPermDto> funcPerms;
    private List<RoleAssignmentMetaDto> members;
}
