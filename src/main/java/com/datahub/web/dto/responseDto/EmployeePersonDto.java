package com.datahub.web.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * Create by HuQiuYue on 2020/9/9
 */
@JsonIgnoreProperties
@Data
public class EmployeePersonDto {
    
    private String mobile;
    
    private String email;
    
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date hireDate;
    
    private String residenceCode;
    private String residenceCodePFC;//仅给每刻用
    
    private String cnName;
    
    private String firstName;
    
    private String middleName;
    
    private String lastName;
    
    private BaseMetaInfoDto nationalityInfo;

    
    private String gender;
    
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthday;
    
    private String identityNo;
    
    private String passportNo;
    
    private String militaryOfficerNo;
    
    private String hkMacaoPassNo;
}
