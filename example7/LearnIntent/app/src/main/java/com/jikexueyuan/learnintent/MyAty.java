package com.jikexueyuan.learnintent;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by dej on 2016/9/27.
 */
public class MyAty extends Activity {

    public static final String ACTION = "com.jikexueyuan.learnintent.intent.action.MyAty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.myaty);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
