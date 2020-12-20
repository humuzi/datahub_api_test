package com.datahub.common.dto;

import com.datahub.common.constant.ResultCode;

/**
 * Create by HuQiuYue on 2020/6/10
 */
public class ResultFactory {
    private ResultFactory() {
    }

    public static ResponseDto toAck(String msg) {
        return new ResponseDto<>(ResultCode.ACK, msg);
    }

    public static <D, R> ResponseDto<D, R> toAck(String msg, D data) {
        return new ResponseDto<>(ResultCode.ACK, msg, data);
    }

    public static <D, E> ResponseDto<D, E> toAckWithError(String msg, D data, E errData) {
        return new ResponseDto<>(ResultCode.ACK, msg, data, errData);
    }

    public static ResponseDto toNack(String msg) {
        return new ResponseDto<>(ResultCode.NACK, msg);
    }

    public static <D, E> ResponseDto<D, E> toNack(String msg, E errData) {
        return new ResponseDto<>(ResultCode.NACK, msg, null, errData);
    }

//    public static ResponseDto toNack(DisplayableError error) {
////        String msg = "";
////        if (error != null && StringUtils.isNotBlank(error.getErrorCode())) {
////            msg = MessageUtil.getMessage(error.getDisplayMsg(), error.getArgs());
////        }
////        return toNack(msg);
////    }
}
