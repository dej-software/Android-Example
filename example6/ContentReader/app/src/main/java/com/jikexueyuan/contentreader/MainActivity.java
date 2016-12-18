package com.jikexueyuan.contentreader;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Uri URI = Uri.parse("content://com.jikexueyuan.myprovider");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = getContentResolver().query(URI, null, null, null, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
            cursor.moveToNext();
        }
    }
}
