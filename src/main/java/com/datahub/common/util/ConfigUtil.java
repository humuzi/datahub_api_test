package com.datahub.common.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Create by HuQiuYue on 2020/6/5
 */

public class ConfigUtil {

    public static String getOAPIBaseUrl(){
        return "https://hub-dev.maycur.com/api/openapi";
    }
    public static String getWebBaseUrl(){
        return "https://hub-uat.maycur.com/api/web";
    }

    public static String getPlatformBaseUrl(){
        return "https://hub-uat.maycur.com/api/platform";
    }

    public static String getMobileBaseUrl(){
        return "https://hub-dev.maycur.com/api/mobile";
    }

    public static String getTestDataPath(){
        return  "/Users/Lee/Documents/datahub_api_test/src/main/resources/testdata";
    }
}
