package com.jikexueyuan.hellojni;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by dej on 2016/11/26.
 */

public class Tools {

    public static Context context = null;

    public static void init(Context context) {
        Tools.context = context;
    }

    public static void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
