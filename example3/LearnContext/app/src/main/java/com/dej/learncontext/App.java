package com.dej.learncontext;

import android.app.Application;

/**
 * Created by dej on 2016/9/12.
 */
public class App extends Application {

    private String textData = "default";

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }
}
