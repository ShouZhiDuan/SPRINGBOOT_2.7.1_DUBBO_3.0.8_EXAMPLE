package com.nvclouds.medusaskadicommon.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ShouZhi@Duan
 * @Description: 日期处理工具类
 */
public class DateUtil {

    private static final Object lockObj = new Object();

    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    /**
     * Date->String
     * thread save
     */
    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    /**
     * String->Date
     * thread save
     */
    public static Date parse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }

    /**
     * Date->LocalDateTime
     */
    public static LocalDateTime parse(Date date){
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = date
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        return localDateTime;
    }

    public static String getCalculateDay(Date initDate,int n){
        //返回推算后的日期
        String calculateDay = "";
        //转换成1970年0时0分的毫秒数
        Long initMilliSeconds = initDate.getTime();
        //一天代表的毫秒数
        int oneDayTime = 24*60*60*1000;
        initMilliSeconds += oneDayTime*n;
        //推算出日期
        Date calculateDate = new Date(initMilliSeconds);
        calculateDay = format(calculateDate,"yyyy-MM-dd");
        return calculateDay;
    }

    /**
     * 双重检查
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    //只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            }
        }
        return tl.get();
    }

}
