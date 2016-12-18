package com.jikexueyuan.listviewexample.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.jikexueyuan.listviewexample.R;
import com.jikexueyuan.listviewexample.models.Student;

public class CustomListActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new CustomListAdapter(this);
        listView.setAdapter(adapter);

        adapter.add(new Student("XiaoLi", 16));
        adapter.add(new Student("XiaoHua", 17));
        adapter.add(new Student("XiaoMing", 18));
        adapter.add(new Student("XiaoLi", 19));
        adapter.add(new Student("XiaoHua", 20));
        adapter.add(new Student("XiaoMing", 21));
        adapter.add(new Student("XiaoLi", 22));
        adapter.add(new Student("XiaoHua", 23));
        adapter.add(new Student("XiaoMing", 24));
        adapter.add(new Student("XiaoLi", 25));
        adapter.add(new Student("XiaoHua", 26));
        adapter.add(new Student("XiaoMing", 27));
        adapter.add(new Student("XiaoHua", 28));
        adapter.add(new Student("XiaoMing", 29));
        adapter.add(new Student("XiaoLi", 30));
        adapter.add(new Student("XiaoHua", 31));
        adapter.add(new Student("XiaoMing", 32));
    }
}
