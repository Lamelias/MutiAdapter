package com.imreal.mutiadapter.utils;

import android.util.Log;

public class Logger {

    public static final boolean sDebug = false;

    public static void d(String tag, String formats, Object... args) {
        if (sDebug) {
            Log.d(tag, String.format(formats, args));
        }
    }

}
