package src/main/resources/mybatis;

import com.datahub.domain.SubsidiaryInformation;

public interface SubsidiaryInformationMapper {
    int insert(SubsidiaryInformation record);

    int insertSelective(SubsidiaryInformation record);
}