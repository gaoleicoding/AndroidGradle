package com.gradle;

import android.util.Log;

/**
 * Created by gaolei on 2018/4/13.
 */

public class LogUtil {
    static boolean  DEBUG = BuildConfig.LOG_DEBUG;

   public static void d(String tag, String message) {
        if (DEBUG)
            Log.d(tag, message);
    }
}
