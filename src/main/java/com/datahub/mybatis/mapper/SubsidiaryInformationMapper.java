package com.datahub.mybatis.mapper;

import com.datahub.domain.SubsidiaryInformation;
import com.datahub.platform.dto.SubsidiaryInfo;
import com.datahub.web.dto.responseDto.BaseMetaInfoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubsidiaryInformationMapper {

     List getAllSubsidiaryInfo(String entCode);

     List<String> getAllSubsidiaryCodes(String entCode);

     BaseMetaInfoDto getSubsidiaryInfo(String entCode);

     List getSubsidiaryTree(@Param("entCode") String entCode,@Param("subsidiaryCode") String subsidiaryCode);

     List getSubsidiaryCode(@Param("entCode") String entCode,@Param("subsidiaryCode") String subsidiaryCode);
     SubsidiaryInformation getSubsidiaryDetail(@Param("entCode")String entCode, @Param("businessCode")String businessCode);

     void deleteData(@Param("entCode")String entCode,@Param("businessCode")String businessCode);

}