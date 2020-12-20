package com.datahub.common.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Create by HuQiuYue on 2020/9/1
 */
public class Base64Utils {
    // 加密
    public static String encryptWithBase64(String waitEncryptString) {
        String result = null;
        try {
            result = Base64.encodeBase64String(waitEncryptString.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 解密
    public static String decryptWithBase64(String waitDecryptString) {
        String result = null;
        byte[] bytes = Base64.decodeBase64(waitDecryptString);
        try {
            result = new String(bytes,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
