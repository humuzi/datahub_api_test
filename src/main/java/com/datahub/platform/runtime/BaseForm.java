package com.datahub.platform.runtime;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Create by HuQiuYue on 2020/11/24
 */
@Component
@Data
public class BaseForm {
    private String businessCode;
    private String code;
    private String name;
}
