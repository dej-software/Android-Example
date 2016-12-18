package com.jikexueyuan.listviewexample.controllers;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jikexueyuan.listviewexample.R;
import com.jikexueyuan.listviewexample.models.Student;

public class ArrayAdapterExampleActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1);
        adapter.add(new Student("Hello", 100));
        adapter.add(new Student("Android", 20));
        adapter.add(new Student("Jikexueyuan", 10));

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Student item = adapter.getItem(position);

                new AlertDialog.Builder(ArrayAdapterExampleActivity.this)
                        .setTitle("详细信息")
                        .setMessage("名字：" + item.getName() + ",年龄：" + item.getAge())
                        .setPositiveButton("关闭", null)
                        .show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(ArrayAdapterExampleActivity.this)
                        .setTitle("提示")
                        .setMessage("你是否要删除该项")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.remove(adapter.getItem(position));
                            }
                        })
                        .show();

                return true;
            }
        });
    }
}
