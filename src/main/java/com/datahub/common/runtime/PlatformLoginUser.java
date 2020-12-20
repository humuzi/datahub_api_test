package com.datahub.common.runtime;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Create by HuQiuYue on 2020/6/3
 */
@Data
@Component
public class PlatformLoginUser {
    private String entCode;
    private String tokenId;
}
