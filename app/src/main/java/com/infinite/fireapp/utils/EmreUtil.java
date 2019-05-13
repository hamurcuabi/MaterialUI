package com.infinite.fireapp.utils;

import java.util.Calendar;

public class EmreUtil {

    public static final int POINT = 1;
    public static final int DEFAULT_POINT = 10;
    public static final String ADMIN_PHONE = "+905063635251";
    public static final String ADMIN_PHONE_2 = "+905396335745";

    public static Calendar calendarOnline;
    public static Calendar calendarOffline;

    public static int diffrences() {
        if (calendarOnline.equals(null)) calendarOnline = Calendar.getInstance();
        long diff = calendarOffline.getTimeInMillis() - calendarOnline.getTimeInMillis();
        return (int) (diff / (60 * 1000));
    }

    public static Calendar getCalendarOnline() {
        return calendarOnline;
    }

    public static void setCalendarOnline(Calendar calendarOnline) {
        EmreUtil.calendarOnline = calendarOnline;
    }

    public static Calendar getCalendarOffline() {
        return calendarOffline;
    }

    public static void setCalendarOffline(Calendar calendarOffline) {
        EmreUtil.calendarOffline = calendarOffline;
    }
}
