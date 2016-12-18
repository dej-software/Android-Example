package com.jikexueyuan.usingsqlite;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Db db;
    private SQLiteDatabase dbRead, dbWrite;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    private EditText etName, etSex;
    private Button btnAdd;

    private View.OnClickListener btnAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ContentValues cv = new ContentValues();
            cv.put("name", etName.getText().toString());
            cv.put("sex", etSex.getText().toString());

            dbWrite.insert("user", null, cv);

            refreshListView();
        }
    };

    private AdapterView.OnItemLongClickListener listViewItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("提醒")
                    .setMessage("确定要删除该项吗")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Cursor c = adapter.getCursor();
                            c.moveToPosition(position);
                            int itemId = c.getInt(c.getColumnIndex("_id"));
                            dbWrite.delete("user", "_id=?", new String[]{itemId + ""});
                            refreshListView();
                        }
                    })
                    .setNegativeButton("取消",null)
                    .show();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.etName);
        etSex = (EditText) findViewById(R.id.etSex);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(btnAddListener);

        db = new Db(this);
        dbRead = db.getReadableDatabase();
        dbWrite = db.getWritableDatabase();

        adapter = new SimpleCursorAdapter(this, R.layout.user_list_cell, null, new String[]{"name", "sex"}, new int[]{R.id.tvName, R.id.tvSex});
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(listViewItemLongClickListener);

        refreshListView();
    }

    private void refreshListView() {
        Cursor c = dbRead.query("user", null, null, null, null, null, null);
        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex("name"));
            String sex = c.getString(c.getColumnIndex("sex"));
            System.out.println(String.format("name = %s, sex = %s", name, sex));
        }

        adapter.changeCursor(c);
    }
}
