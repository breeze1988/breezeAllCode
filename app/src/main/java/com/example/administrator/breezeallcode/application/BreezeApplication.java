package com.example.administrator.breezeallcode.application;

import android.app.Application;

/**
 * Created by Administrator on 2015/11/12.
 */
public class BreezeApplication extends Application{

    private static BreezeApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static BreezeApplication getmInstance(){
        return mInstance;
    }
}
