package com.jikexueyuan.listviewexample.models;

/**
 * Created by dej on 2016/9/30.
 */
public abstract class ExampleItem {

    private String label;

    public ExampleItem(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public abstract void onAction();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
