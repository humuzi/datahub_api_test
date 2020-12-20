package com.datahub.common.util;

import lombok.Data;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Create by HuQiuYue on 2020/10/23
 */
@Data
public class DateUtil {


//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    Calendar calendar = Calendar.getInstance();

    public static final String TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

    public DateUtil(){
//        calendar.setTime(new Date());
//        calendar.add(Calendar.MONTH,-1);
//        startDate = sdf.format(calendar.getTime());
//        endDate = sdf.format(new Date());
//        startDate = new DateTime().toString(DateUtil.TIME_FORMAT_PATTERN);
    }





}
