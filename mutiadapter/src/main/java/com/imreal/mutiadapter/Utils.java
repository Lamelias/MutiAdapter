package com.imreal.mutiadapter;

import android.content.res.Resources;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static String getDateDefault() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    public static String getDateFormat(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    public static TextView getView(ViewGroup parent) {
        TextView view = new TextView(parent.getContext());
        view.setGravity(Gravity.CENTER);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        view.setLayoutParams(lp);
        return view;
    }

    /**
     * getInteger(com.android.internal.R.integer.config_cursorWindowSize);
     *
     * @param name
     * @param type
     * @return
     */
    public static int getInternalRInteger(String name, String type) {
        Resources resources = Resources.getSystem();
        int id = resources.getIdentifier("config_cursorWindowSize", "integer", "android");
        return resources.getInteger(id);
    }

    public static void d(String tag, String formats, Object... args) {
        Log.d(tag, String.format(formats, args));
    }

    public static long getTimestamp(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
        Date date = null;
        try {
            date = sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            return date.getTime();
        } else {
            return System.currentTimeMillis();
        }
    }

    /**
     * Retrieve a time category of this specified timestamp
     * 0 today  1 yesterday 2 this week  3 last week 4 earlier
     *
     * @param timestamp    timestamp in milliseconds to be compared
     * @param isSundayLast if true, sunday will be considered as the last day in a week
     * @return category
     */
    public static int getCategory(long timestamp, boolean isSundayLast) {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTimeInMillis(System.currentTimeMillis());

        Calendar oldCalendar = Calendar.getInstance();
        oldCalendar.setTimeInMillis(timestamp);

        currentCalendar.set(Calendar.HOUR_OF_DAY, 0);
        oldCalendar.set(Calendar.HOUR_OF_DAY, 0);

        int year = currentCalendar.get(Calendar.YEAR);
        int month = currentCalendar.get(Calendar.MONTH);
        int day = currentCalendar.get(Calendar.DAY_OF_MONTH);
        int week = currentCalendar.get(Calendar.DAY_OF_WEEK);

        int year1 = oldCalendar.get(Calendar.YEAR);
        int month1 = oldCalendar.get(Calendar.MONTH);
        int day1 = oldCalendar.get(Calendar.DAY_OF_MONTH);

        int weekDelta = isSundayLast ? week - 1 : week;
        int category = 6;

        if (year == year1) {
            int monthDiff = month - month1;
            if (monthDiff == 0) {
                int dayDiff = day - day1;
                if (dayDiff == 0) {
                    category = 0;
                } else if (dayDiff == 1) {
                    category = 1;
                } else if (dayDiff < weekDelta) {
                    category = 2;
                } else if (dayDiff < weekDelta + 7) {
                    category = 3;
                } else {
                    category = 4;
                }
            } else if (monthDiff == 1) {
                category = 5;
            }
        }
        return category;
    }


}
