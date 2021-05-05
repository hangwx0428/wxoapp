/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.hang.wxoapp.contentgen.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * @author allen.lg
 * @version DateUtil.java, v 0.1 2017-03-30 15:05 allen.lg Exp $
 */
public class DateUtil extends DateUtils {

    public final static String                                shortFormat     = "yyyyMMdd";

    /**
     * 校验时间字符串格式
     * @param sDate
     * @param formatStr
     * @return
     */
    public static boolean checkFormat (String sDate, String formatStr) {
        if(StringUtils.isBlank(sDate)){
            return false;
        }
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        try {
            Date date = dateFormat.parse(sDate);
            return date != null;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return c.getTime();
    }

    /**
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * @return
     */
    public static Date getFirstDayOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_YEAR, 1);
        return c.getTime();
    }

    /**
    *
     * @param start
     * @param end
     * @return
     */
    public static boolean isNowBetween(Date start, Date end) {
        if (start == null || end == null) {
            return false;
        }
        long current = (new Date()).getTime();
        if (current >= start.getTime() && current < end.getTime()) {
            return true;
        }

        return false;
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeek(Date date1, Date date2) {
        return isSameDay(getFirstDayOfWeek(date1), getFirstDayOfWeek(date2));
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        return isSameDay(getFirstDayOfMonth(date1), getFirstDayOfMonth(date2));
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameYear(Date date1, Date date2) {
        return isSameDay(getFirstDayOfYear(date1), getFirstDayOfYear(date2));
    }

    /**
     *
     * @param date
     * @return
     */
    public static Date getFinalTimeOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return c.getTime();
    }

    /**
     * 获取这个日期的零点零分零秒
     * @param date
     * @return
     */
    public static Date getStartTimeOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MILLISECOND, 0);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return c.getTime();
    }

    /**
     */
    public static Long getIntervalMinutes(Date startTime, Date endTime) {
        if(null == startTime || null == endTime || endTime.before(startTime)) {
            throw new IllegalArgumentException("");
        }
        return (endTime.getTime() - startTime.getTime())/(1000L * 60);
    }

    public static String getDateString(Date date) {
        DateFormat df = getNewDateFormat(shortFormat);

        return df.format(date);
    }

    public static DateFormat getNewDateFormat(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);

        df.setLenient(false);
        return df;
    }

    /**
     * one是否在other之前
     * @param one
     * @param other
     * @return
     */
    public static boolean isBefore(Date one, Date other) {
        if (one == null && other == null) {
            return false;
        }
        if (one == null && other != null) {
            return false;
        }
        if (one != null && other == null) {
            return true;
        }
        return one.before(other);
    }


    /**
     * 将long类型的时间转换为date
     * @param dateLong 毫秒时间
     * @return
     */
    public static Date formateDate(long dateLong) {
        Date d = new Date();
        d.setTime(dateLong);
        return d;
    }


    /**
     * 计算第一个日期和第二个日期隔X天
     * @param one
     * @param other
     * @return
     */
    public static int getBetweenDay(Date one, Date other) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        if (other.getTime() - one.getTime() > 0) {
            c1.setTime(one);
            c2.setTime(other);
        } else {
            c1.setTime(other);
            c2.setTime(one);
        }

        int days = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
        int years = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        for (int i = 0; i < years; i++) {
            days += c1.getActualMaximum(Calendar.DAY_OF_YEAR);
            c1.add(Calendar.YEAR, 1);
        }

        return days;
    }

    /**
     * 计算第一个日期和第二个日期隔X天
     * @param one
     * @param other
     * @return
     */
    public static int getBetweenDay(long one, long other) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        if (other - one > 0) {
            c1.setTimeInMillis(one);
            c2.setTimeInMillis(other);
        } else {
            c1.setTimeInMillis(other);
            c2.setTimeInMillis(one);
        }

        int days = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
        int years = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        for (int i = 0; i < years; i++) {
            days += c1.getActualMaximum(Calendar.DAY_OF_YEAR);
            c1.add(Calendar.YEAR, 1);
        }

        return days;
    }

    /**
     * 计算时间与当前时间的天数时间差
     *
     * @param endTimeDate 时间
     * @return 天数时间差
     */
    public static Integer calDeadlineDayCount(Date endTimeDate) {
        if (endTimeDate == null) {
            return null;
        }
        return (int) ((endTimeDate.getTime() - System.currentTimeMillis())
                / (60 * 60 * 1000 * 24));

    }

    public static Date parseDateNoTime(String sDate, String format){
        if(StringUtils.isBlank(sDate)){
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(sDate);
        } catch (ParseException e) {

        }
        return null;
    }

    /**
     * 判断当前时间是否在一定区间
     * @return
     */
    public static boolean checkCurHourBetween(String startTimeStr, String endTimeStr){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int curhour = calendar.get(Calendar.HOUR_OF_DAY);
        int curMin = calendar.get(Calendar.MINUTE);
        int curTime = curhour * 60 + curMin;

        String[]startTimeStrs = startTimeStr.split(":");
        String[]endTimeStrs = endTimeStr.split(":");

        int startHour = Integer.valueOf(startTimeStrs[0]);
        int startMin =Integer.valueOf(startTimeStrs[1]);
        int endHour =Integer.valueOf(endTimeStrs[0]);
        int endMin =Integer.valueOf(endTimeStrs[1]);

        int startTime = startHour * 60 + startMin;
        int endTime = endHour * 60 + endMin;

        if(curTime>=startTime && curTime<=endTime){
            return true;
        }
        return false;
    }
}
