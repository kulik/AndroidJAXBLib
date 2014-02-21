package com.kulik.android.jaxb.library.loger;

/**
 * Created by kulik on 2/1/14.
 */
public class Log {
    public enum Level {
        VERBOSE(1), DEBUG(2), INFO(3), WARN(4), ERROR(5), OFF(6);
        private final int mOrd;

        Level(int i) {
            mOrd = i;
        }

        public boolean canLog(Level l) {
            return (this.mOrd >= l.mOrd);
        }
    }

    public static void setLogLevel(Level sLevel) {
        Log.sLevel = sLevel;
    }

    private static Level sLevel = Level.VERBOSE;

    public static void i(String tag, String message) {
        Level l = Level.INFO;
        if (l.canLog(sLevel)) {
            android.util.Log.i(tag, message);
        }
    }

    public static void i(String tag, String message, Throwable e) {
        Level l = Level.INFO;
        if (l.canLog(sLevel)) {
            android.util.Log.i(tag, message, e);
        }
    }

    public static void v(String tag, String message) {
        Level l = Level.VERBOSE;
        if (l.canLog(sLevel)) {
            android.util.Log.v(tag, message);
        }
    }

    public static void v(String tag, String message, Throwable e) {
        Level l = Level.VERBOSE;
        if (l.canLog(sLevel)) {
            android.util.Log.v(tag, message, e);
        }
    }

    public static void d(String tag, String message) {
        Level l = Level.DEBUG;
        if (l.canLog(sLevel)) {
            android.util.Log.v(tag, message);
        }
    }

    public static void d(String tag, String message, Throwable e) {
        Level l = Level.DEBUG;
        if (l.canLog(sLevel)) {
            android.util.Log.v(tag, message, e);
        }
    }

    public static void w(String tag, String message) {
        Level l = Level.WARN;
        if (l.canLog(sLevel)) {
            android.util.Log.v(tag, message);
        }
    }

    public static void e(String tag, String message, Throwable e) {
        Level l = Level.ERROR;
        if (l.canLog(sLevel)) {
            android.util.Log.e(tag, message, e);
        }
    }

    public static void e(String tag, String message) {
        Level l = Level.ERROR;
        if (l.canLog(sLevel)) {
            android.util.Log.e(tag, message);
        }
    }


}
