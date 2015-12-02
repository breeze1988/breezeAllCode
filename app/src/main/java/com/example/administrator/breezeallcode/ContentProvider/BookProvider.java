package com.example.administrator.breezeallcode.ContentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.administrator.breezeallcode.dao.DbOpenHelper;
import com.example.administrator.breezeallcode.util.Logger;

/**
 * 一个contentprovider的例子
 * Created by Administrator on 2015/12/1.
 */
public class BookProvider extends ContentProvider {

    private static final String TAG = "BOOKPROVIDER";

    public static final String AUTHORITY = "com.example.administrator.breezeallcode.ContentProvider.BookProvider";

    public static final Uri BOOK_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/book");
    public static final Uri USER_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/user");

    public static final int BOOK_URI_CODE = 0;
    public static final int USER_URI_CODE = 1;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY, "book", BOOK_URI_CODE);
        sUriMatcher.addURI(AUTHORITY, "user", USER_URI_CODE);
    }

    private Context mContext;
    private SQLiteDatabase mDb;


    @Override
    public boolean onCreate() {
        Logger.i(TAG, "onCreate,current thread:" + Thread.currentThread().getName());
        mContext = getContext();
        //初始化数据库，建议放在多线程做此动作
        initProviderData();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Logger.i(TAG, "query,current thread:" + Thread.currentThread().getName());
        String table = getTableName(uri);
        if (null == table) {
            throw new IllegalArgumentException("Unsupported URI:" + uri);
        }
        return mDb.query(table, projection, selection, selectionArgs, null, null, sortOrder, null);
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
        String table = getTableName(uri);
        if (null == table) {
            throw new IllegalArgumentException("Unsupported URI:" + uri);
        }
        mDb.insert(table, null, contentValues);
        mContext.getContentResolver().notifyChange(uri, null);
        return uri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        Logger.i(TAG, "delete");
        String table = getTableName(uri);
        if (null == table) {
            throw new IllegalArgumentException("Unsupported URI:" + uri);
        }
        int count = mDb.delete(table, s, strings);
        if (count > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        Logger.i(TAG, "update");
        String table = getTableName(uri);
        if (null == table) {
            throw new IllegalArgumentException("Unsupported URI:" + uri);
        }
        int row = mDb.update(table, contentValues, s, strings);
        if (row > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return row;
    }

    private void initProviderData() {
        mDb = new DbOpenHelper(mContext).getWritableDatabase();
        mDb.execSQL("delete from " + DbOpenHelper.BOOK_TABLE_NAME);
        mDb.execSQL("delete from " + DbOpenHelper.USER_TABLE_NAME);
        mDb.execSQL("insert into book values(3,'android');");
        mDb.execSQL("insert into book values(4,'ios');");
        mDb.execSQL("insert into book values(5,'html5');");
        mDb.execSQL("insert into user values(1,'jake',1);");
        mDb.execSQL("insert into user values(1,'breeze',0);");
    }

    private String getTableName(Uri uri) {
        String tableName = null;
        switch (sUriMatcher.match(uri)) {
            case BOOK_URI_CODE:
                tableName = DbOpenHelper.BOOK_TABLE_NAME;
                break;
            case USER_URI_CODE:
                tableName = DbOpenHelper.USER_TABLE_NAME;
                break;
            default:
                break;
        }
        return tableName;
    }
}
