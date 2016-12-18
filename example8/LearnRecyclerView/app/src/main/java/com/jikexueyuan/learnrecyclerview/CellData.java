package com.jikexueyuan.learnrecyclerview;

/**
 * Created by dej on 2016/10/4.
 */
public class CellData {

    public CellData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    private String title = "title";
    private String content = "content";

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
