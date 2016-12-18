package com.jikexueyuan.preferenceactivity;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by dej on 2016/10/25.
 */
public class MyPreferenceActivity extends PreferenceActivity {

    private PreferenceManager manager;
    private CheckBoxPreference checkBoxPreference;
    private ListPreference listPreference;
    private EditTextPreference editTextPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.my_preference);

        manager = getPreferenceManager();
        checkBoxPreference = (CheckBoxPreference) manager.findPreference("checkbox");
        Toast.makeText(this, "当前状态为：" + checkBoxPreference.isChecked(), Toast.LENGTH_SHORT).show();

        listPreference = (ListPreference) manager.findPreference("list");
        Toast.makeText(this, listPreference.getEntry() + "的开发环境为" + listPreference.getValue(), Toast.LENGTH_SHORT).show();

        editTextPreference = (EditTextPreference) manager.findPreference("text");
        Toast.makeText(this, "你的名字为：" + editTextPreference.getText(), Toast.LENGTH_SHORT).show();
    }
}
