package com.jikexueyuan.listviewexample.models;

/**
 * Created by dej on 2016/10/4.
 */
public class CheckBoxItem {

    private String label;
    private boolean checked = false;

    public CheckBoxItem(String label, boolean checked) {
        this.label = label;
        this.checked = checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
