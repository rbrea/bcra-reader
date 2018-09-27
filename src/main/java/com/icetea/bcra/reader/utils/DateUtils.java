package com.icetea.bcra.reader.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

public final class DateUtils
    extends org.apache.commons.lang3.time.DateUtils {

    public static final String DEFAULT_PATTERN = "dd/MM/yyyy HH:mm:ss";
    public static final String FRENCH_PATTERN = "dd/MM/yyyy";
    public static final String UTC = "UTC";
    public static final String FILE_PATTERN = "yyyyMMddHHmmss";

    public static String toDate(Date date, String pattern, String timezone) {
        if (date == null) {
            return null;
        }
        Preconditions.checkArgument(StringUtils.isNotBlank(pattern), "pattern is required");

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if (StringUtils.isNotBlank(timezone)) {
            TimeZone tz = TimeZone.getTimeZone(timezone);
            if (tz != null) {
                sdf.setTimeZone(tz);
            }
        }

        return sdf.format(date);
    }

    public static String toDate(Date date, String pattern) {
        return toDate(date, pattern, null);
    }

    public static String toDate(Date date) {
        return toDate(date, DEFAULT_PATTERN);
    }

    public static Date parseDate(String value, String pattern) {
        if (StringUtils.isBlank(value)) {
            return null;
        }

        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(value, pattern);
        } catch (ParseException e) {
            throw new RuntimeException("cannot parse to Date value: " + value, e);
        }
    }

    public static Date parseDate(String value) {
        return parseDate(value, DEFAULT_PATTERN);
    }

    public static String convertDateToTimeZone(String value, String timezone) {
        Date d = parseDate(value);

        return toDate(d, DateUtils.DEFAULT_PATTERN, timezone);
    }

    /**
     * @param date
     * @return [roher] llevo la fecha hasta a 23:59:59 para tomar todo lo q este durante ese dia ...
     */
    public static Date lastSecondOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }

    public static Date now() {
        return new Date();
    }

    /**
     * It wants to take hour of the date to 00:00:00. <br>e.g. 30/04/1982 13:00:00 to 30/04/1982 00:00:00.
     * 
     * @param date
     * @return
     */
    public static Date truncate(Date date) {
        return truncate(date, Calendar.DAY_OF_MONTH);
    }

    public static Date nowTruncated() {
        return truncate(new Date());
    }

    public static String nowString() {
        return toDate(now());
    }

    public static String nowTruncatedString() {
        return toDate(nowTruncated());
    }

    public static long millisToSeconds(long millis) {
        return millis / 1000;
    }

    public static long secondsToMinutes(long seconds) {
        return seconds / 60;
    }

    public static long millisToMinutes(long millis) {
        return secondsToMinutes(millisToSeconds(millis));
    }

    public static Date toUTC(Date input) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DEFAULT_PATTERN);
        sdf.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, UTC));
        Date utcDate = null;
        try {
            utcDate = sdf.parse(toDate(input));
        } catch (ParseException e) {
            // nothing to do
        }

        return utcDate;
    }

    public static boolean isBefore(Date value, Date comparedValue) {
        if (value == null || comparedValue == null) {
            return false;
        }

        return value.before(comparedValue);
    }

    public static int getDiffInDays(final Date from, final Date until) {
        if (from == null || until == null) {
            return -9999;
        }

        long fromInMillis = from.getTime();
        long untilInMillis = until.getTime();

        long diffTime = untilInMillis - fromInMillis;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(until);

        start.add(Calendar.DAY_OF_MONTH, (int) diffDays);
        while (start.before(end)) {
            start.add(Calendar.DAY_OF_MONTH, NumberUtils._1);
            diffDays++;
        }
        while (start.after(end)) {
            start.add(Calendar.DAY_OF_MONTH, -1);
            diffDays--;
        }

        return NumberUtils.createInteger(String.valueOf(diffDays));
    }

    public static boolean isNotBefore(Date value, Date comparedValue) {
        return !isBefore(value, comparedValue);
    }

    public static int getDiffInHours(final Date from, final Date until) {
        return getDiffInMinutes(from, until) / 60;
    }

    public static int getDiffInMinutes(final Date from, final Date until) {
        return getDiffInSeconds(from, until) / 60;
    }

    public static int getDiffInSeconds(final Date from, final Date until) {
        if (from == null || until == null) {
            return -9999;
        }

        long secondsBetween = (until.getTime() - from.getTime()) / 1000;

        return NumberUtils.createInteger(String.valueOf(secondsBetween));
    }

    public static int getDiffInMillis(final Date from, final Date until) {
        if (from == null || until == null) {
            return -9999;
        }

        long millisBetween = until.getTime() - from.getTime();

        return NumberUtils.createInteger(String.valueOf(millisBetween));
    }

    public static Date addDays(final Date date, final int days) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        return calendar.getTime();
    }
}
