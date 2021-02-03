package com.alvin.common.util;

import org.springframework.util.Assert;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 日期工具类
 * 日期大小比较
 * 日期加减
 * 时间戳转换
 *
 * @author tianyunperfect
 * @date 2020/05/28
 */
public class DateUtils {

    /**
     * 当前秒
     *
     * @return {@link Long}
     */
    public static Long getEpochMilli() {
        return Instant.now().toEpochMilli();
    }

    /**
     * 当前秒
     *
     * @return {@link Long}
     */
    public static Long getEpochSecond() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time) {
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToLong(String time) {
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse("2018-05-29 13:52:50", ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 取本月第一天
     */
    public static LocalDate firstDayOfThisMonth() {
        LocalDate today = LocalDate.now();
        return today.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 取本月第N天
     */
    public static LocalDate dayOfThisMonth(int n) {
        LocalDate today = LocalDate.now();
        return today.withDayOfMonth(n);
    }

    /**
     * 取本月最后一天
     */
    public static LocalDate lastDayOfThisMonth() {
        LocalDate today = LocalDate.now();
        return today.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 取本月第一天的开始时间
     */
    public static LocalDateTime startOfThisMonth() {
        return LocalDateTime.of(firstDayOfThisMonth(), LocalTime.MIN);
    }


    /**
     * 取本月最后一天的结束时间
     */
    public static LocalDateTime endOfThisMonth() {
        return LocalDateTime.of(lastDayOfThisMonth(), LocalTime.MAX);
    }

}
