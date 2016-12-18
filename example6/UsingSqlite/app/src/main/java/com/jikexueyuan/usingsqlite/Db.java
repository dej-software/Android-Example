package com.jikexueyuan.usingsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dej on 2016/9/24.
 */
public class Db extends SQLiteOpenHelper {

    public Db(Context context) {
        super(context, "db", null, 1);
    }

    public Db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT DEFAULT \"\","
                + "sex TEXT DEFAULT \"\""
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
