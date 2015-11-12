package com.example.administrator.breezeallcode.util;

import android.content.Context;

import com.example.administrator.breezeallcode.application.BreezeApplication;

/**
 * Created by Administrator on 2015/11/12.
 */
public class ApplicationUtil {
    public static Context getAppContext(){
        return BreezeApplication.getmInstance();
    }
}
