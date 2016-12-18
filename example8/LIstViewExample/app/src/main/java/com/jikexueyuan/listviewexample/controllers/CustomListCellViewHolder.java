package com.jikexueyuan.listviewexample.controllers;

import android.widget.TextView;

/**
 * Created by dej on 2016/10/4.
 */
public class CustomListCellViewHolder {
    private TextView tvTitle, tvDesc;

    public CustomListCellViewHolder(TextView tvTitle, TextView tvDesc) {
        this.tvTitle = tvTitle;
        this.tvDesc = tvDesc;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvDesc() {
        return tvDesc;
    }
}
