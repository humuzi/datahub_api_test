package com.datahub.common.dto;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Create by HuQiuYue on 2020/6/5
 */
@Data
public class ResponseDto<D,E> {
    private String code;
    private String message;
    private D data;
    private E errData;

    public ResponseDto() {
    }

    public ResponseDto(String code, String message){
        this.code  = code;
        this.message = message;
    }

    public ResponseDto(String code, String message, D data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseDto(String code, String message, D data, E errData) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.errData = errData;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
