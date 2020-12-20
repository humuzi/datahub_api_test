package com.datahub.mybatis.mapper;

import com.datahub.domain.Enterprise;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseMapper {
    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    String getEnterpriseName(String entCode);
}