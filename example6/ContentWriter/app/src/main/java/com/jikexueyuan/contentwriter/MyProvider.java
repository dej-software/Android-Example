package com.jikexueyuan.contentwriter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by dej on 2016/9/25.
 */
public class MyProvider extends ContentProvider {

    public static final Uri URI = Uri.parse("content://com.jikexueyuan.myprovider");

    // ContentProvider的操作类似数据库的操作，声明一个SQLiteDatabase来作为数据对象
    SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        database = getContext().openOrCreateDatabase("mycp.db3", Context.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS tab("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL"
                + ")");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = database.query("tab",null,null,null,null,null,null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        database.insert("tab", "_id", values);
//        database.close();
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
