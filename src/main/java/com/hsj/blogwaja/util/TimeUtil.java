package com.hsj.blogwaja.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author waja
 */
public class TimeUtil {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static String format(LocalDateTime time){
        return formatter.format(time);
    }
    public static LocalDateTime pares(String dateTime) {
        return LocalDateTime.parse(dateTime, formatter);
    }
}
