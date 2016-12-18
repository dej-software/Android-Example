package com.jikexueyuan.listviewexample.controllers;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import com.jikexueyuan.listviewexample.R;
import com.jikexueyuan.listviewexample.models.CheckBoxItem;

public class CheckboxesExampleActivity extends ListActivity {

    private ArrayAdapter<CheckBoxItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_checkboxes_example);

        adapter = new ArrayAdapter<CheckBoxItem>(this, android.R.layout.select_dialog_multichoice){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                CheckedTextView ctv = (CheckedTextView) super.getView(position, convertView, parent);

                CheckBoxItem item = getItem(position);
                ctv.setChecked(item.isChecked());

                return ctv;
            }
        };
        setListAdapter(adapter);

//        adapter.add("Hello");
//        adapter.add("World");

        for (int i = 0; i < 100; i++) {
            adapter.add(new CheckBoxItem("Item" + i, false));
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
//        System.out.println(v);
//        CheckedTextView ctv = (CheckedTextView) v;
//        ctv.setChecked(!ctv.isChecked());

        CheckBoxItem item = adapter.getItem(position);
        item.setChecked(!item.isChecked());

        adapter.notifyDataSetChanged();
    }
}
