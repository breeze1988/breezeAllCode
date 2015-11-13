package com.example.administrator.breezeallcode.util;

import android.util.Log;

/**
 * Created by Administrator on 2015/11/13.
 */
public class Logger {

    public final static String TAG = "breezeAllCode_log";

    public static boolean isLog = true;

    public static void d(String msg) {
        if (isLog) {
            Log.d(TAG, "" + msg);
        }
    }

    public static void i(String msg) {
        if (isLog)
            Log.i(TAG, "" + msg);
    }

    public static void v(String msg) {
        if (isLog)
            Log.v(TAG, "" + msg);
    }

    public static void w(String msg) {
        if (isLog)
            Log.w(TAG, "" + msg);
    }

    public static void e(String msg) {
        if (isLog)
            Log.e(TAG, "" + msg);
    }

    public static void v(String tag, String msg) {
        if (isLog)
            Log.v(TAG + "---" + tag, "" + msg);
    }

    public static void d(String tag, String msg) {
        if (isLog)
            Log.d(TAG + "---" + tag, "" + msg);
    }

    public static void i(String tag, String msg) {
        if (isLog)
            Log.i(TAG + "---" + tag, "" + msg);
    }

    public static void w(String tag, String msg) {
        if (isLog)
            Log.w(TAG + "---" + tag, "" + msg);
    }

    public static void e(String tag, String msg) {
        if (isLog)
            Log.e(TAG + "---" + tag, "" + msg);
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (isLog)
            Log.e(TAG + "---" + tag, msg, tr);
    }

//    public static boolean write2Log(String log, File logFile, boolean append) {
//        boolean flag = false;
//        if (logFile == null || TextUtils.isEmpty(log)) {
//            return flag;
//        }
//
//        if (logFile.exists() && logFile.length() > 2 * 1024 * 1024) {
//            logFile.delete();
//        }
//        logFile.getParentFile().mkdirs();
//
//        StringBuilder sb = new StringBuilder();
//        if (!logFile.exists() || !append) {// 获取设备信息
//            sb.append(DeviceUtil.getDeviceInfo());
//            sb.append("----------------------------\r\n");
//        }
//
//        sb.append("\r\n");
//        sb.append(DateUtil.formatDate(System.currentTimeMillis(), DateUtil.FORMAT_YYYYMMDDH24MM));
//        sb.append("\r\n").append(log).append("\r\n");
//
//        BufferedWriter writer = null;
//        try {
//            writer = new BufferedWriter(new FileWriter(logFile, append));
//            writer.write(sb.toString());
//            flag = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            StreamUtils.closeIO(writer);
//        }
//
//        return flag;
//    }

}
