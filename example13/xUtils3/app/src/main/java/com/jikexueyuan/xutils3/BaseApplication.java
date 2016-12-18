package com.jikexueyuan.xutils3;

import android.app.Application;

import org.xutils.x;

/**
 * Created by dej on 2016/11/12.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
