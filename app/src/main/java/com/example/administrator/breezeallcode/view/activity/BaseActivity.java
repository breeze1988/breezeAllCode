package com.example.administrator.breezeallcode.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.breezeallcode.util.otto.ScopedBus;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/11/16.
 */
public abstract class BaseActivity extends Activity {

    private CustomHandler mHandler;

    private final ScopedBus scopedBus = new ScopedBus();

    protected ScopedBus getBus() {
        return scopedBus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        scopedBus.paused();
    }

    @Override
    public void onResume() {
        super.onResume();
        scopedBus.resumed();
    }


    //防止handler引起内存泄露
    static class CustomHandler extends Handler {
        private WeakReference<BaseActivity> mActivityReference;

        public CustomHandler(BaseActivity activity) {
            mActivityReference = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            BaseActivity activity = mActivityReference == null ? null : mActivityReference.get();
            if (activity != null) {
                activity.handleMessage(msg);
            }
        }

    }

    protected void handleMessage(Message msg) {
    }

}
