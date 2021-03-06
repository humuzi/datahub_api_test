package com.datahub.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Create by HuQiuYue on 2020/10/26
 */
public class JsonUtil {
    public static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static String toString(final Object object) {
        if(object instanceof String){
            return (String)object;
        }
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try{
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("stringify object failed");
        }
        return null;
    }

    public static <T> T toObject(final String jsonStr, final Class<T> clazz) {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        T object = null;

        if (StringUtils.isEmpty(jsonStr)) {
            return object;
        }

        try {
            object = mapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            logger.error("parse jsonStr {} to class {} failed", jsonStr, clazz.getName(), e);
        }

        return object;
    }

    public static <T> T toObject(String jsonStr, TypeReference<T> valueTypeRef) {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        T object = null;

        if (StringUtils.isEmpty(jsonStr)) {
            return object;
        }

        try {
            object = mapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception e) {
            logger.error("parse jsonStr {} to class {} failed", jsonStr, valueTypeRef.getType(), e);
        }

        return object;
    }

    public static <T> List<T> toList(String jsonStr) {
        return toObject(jsonStr, new TypeReference<List<T>>() {});
    }

    public static <T> List<T> toList(String jsonStr, Class<T> clazz) {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            return mapper.readValue(jsonStr, mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
        } catch (Exception e) {
            logger.debug("parse jsonStr {} to class {} list failed", jsonStr, clazz.getName(), e);
        }
        return Collections.emptyList();
    }

    public static Map<String, Object> toMap(String jsonStr) {
        return toObject(jsonStr, new TypeReference<Map<String, Object>>() {});
    }

    public static String stringify(Object object) {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            logger.error("Stringify failed", e);
            return null;
        }

    }




}
