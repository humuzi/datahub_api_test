package com.datahub.web.runtime;

import lombok.Data;
import org.springframework.stereotype.Component;


/**
 * Create by HuQiuYue on 2020/7/7
 */
@Data
@Component
public  class WebLoginUser {
    private String entCode;
    private String tokenId;
}
