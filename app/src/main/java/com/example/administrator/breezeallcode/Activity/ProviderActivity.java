package com.example.administrator.breezeallcode.Activity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.example.administrator.breezeallcode.ContentProvider.BookProvider;
import com.example.administrator.breezeallcode.util.Logger;

/**
 * Created by Administrator on 2015/12/2.
 */
public class ProviderActivity extends Activity {
    private static final String TAG = "providerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri bookUri = BookProvider.BOOK_CONTENT_URI;
        ContentValues values = new ContentValues();
        values.put("_id", 6);
        values.put("name", "程序设计的艺术");
        getContentResolver().insert(bookUri, values);
        Cursor bookCursor = getContentResolver().query(bookUri, new String[]{"_id", "name"}, null, null, null);
        Book book = new Book();
        while (bookCursor.moveToNext()) {
            book.bookId = bookCursor.getInt(0);
            book.bookName = bookCursor.getString(1);
            Logger.i("query book:" + book.toString());
        }
        bookCursor.close();

    }


}

class Book {
    public int bookId;
    public String bookName;

    @Override
    public String toString() {
        return "bookid = " + bookId + " bookName = " + bookName + "\n";
    }
}
