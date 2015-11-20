package com.example.administrator.breezeallcode.view.activity;

import android.app.Activity;

import com.example.administrator.breezeallcode.util.otto.ScopedBus;

/**
 * Created by Administrator on 2015/11/16.
 */
public abstract class BaseActivty extends Activity {

    private final ScopedBus scopedBus = new ScopedBus();

    protected ScopedBus getBus() {
        return scopedBus;
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

}
