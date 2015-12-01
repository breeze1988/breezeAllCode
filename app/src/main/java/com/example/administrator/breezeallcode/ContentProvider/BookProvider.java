package com.example.administrator.breezeallcode.ContentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.administrator.breezeallcode.util.Logger;

/**
 * 一个contentprovider的例子
 * Created by Administrator on 2015/12/1.
 */
public class BookProvider extends ContentProvider {

    private static final String TAG = "BOOKPROVIDER";

    @Override
    public boolean onCreate() {
        Logger.i(TAG, "onCreate,current thread:" + Thread.currentThread().getName());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Logger.i(TAG, "query,current thread:" + Thread.currentThread().getName());
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Logger.i(TAG, "getType");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Logger.i(TAG, "insert");
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        Logger.i(TAG, "delete");
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        Logger.i(TAG, "update");
        return 0;
    }
}
