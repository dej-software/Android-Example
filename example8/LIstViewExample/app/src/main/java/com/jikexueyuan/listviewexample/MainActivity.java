package com.jikexueyuan.listviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jikexueyuan.listviewexample.controllers.ArrayAdapterExampleActivity;
import com.jikexueyuan.listviewexample.controllers.CheckboxesExampleActivity;
import com.jikexueyuan.listviewexample.controllers.CustomListActivity;
import com.jikexueyuan.listviewexample.controllers.ListActivityExampleActivity;
import com.jikexueyuan.listviewexample.models.ExampleItem;

/**
 * Created by dej on 2016/9/30.
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<ExampleItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<ExampleItem>(this, android.R.layout.simple_list_item_1);
        // config the list item data
        adapter.add(new ExampleItem("ArrayAdapter示例") {
            @Override
            public void onAction() {
                startActivity(new Intent(MainActivity.this, ArrayAdapterExampleActivity.class));
            }
        });
        adapter.add(new ExampleItem("ListActivity示例") {
            @Override
            public void onAction() {
                startActivity(new Intent(MainActivity.this, ListActivityExampleActivity.class));
            }
        });
        adapter.add(new ExampleItem("CheckBoxesListView示例") {
            @Override
            public void onAction() {
                startActivity(new Intent(MainActivity.this, CheckboxesExampleActivity.class));
            }
        });
        adapter.add(new ExampleItem("CustomList示例") {
            @Override
            public void onAction() {
                startActivity(new Intent(MainActivity.this, CustomListActivity.class));
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.getItem(position).onAction();
            }
        });
    }
}
