package com.jikexueyuan.listviewexample.controllers;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.jikexueyuan.listviewexample.R;

public class ListActivityExampleActivity extends ListActivity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity_example);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);

        adapter.add("Hello");
        adapter.add("World");
    }
}
