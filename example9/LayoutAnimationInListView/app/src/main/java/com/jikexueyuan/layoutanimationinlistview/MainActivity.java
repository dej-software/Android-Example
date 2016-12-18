package com.jikexueyuan.layoutanimationinlistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    private ArrayAdapter<String> adapter;
//    private LayoutAnimationController lac;
//    private ScaleAnimation sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"Hello", "World", "Jikexueyuan"});
        setListAdapter(adapter);

//        sa = new ScaleAnimation(0, 1, 0, 1);
//        sa.setDuration(1000);
//        lac = new LayoutAnimationController(sa, 0.5f);
//
//        getListView().setLayoutAnimation(lac);
    }
}
