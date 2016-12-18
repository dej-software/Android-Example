package com.jikexueyuan.usingxmldirectory;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import java.util.List;

/**
 * Created by dej on 2016/10/15.
 */
public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SharedPreferences preferences;

    @Override
    public void onBuildHeaders(List<Header> target) {
        super.onBuildHeaders(target);

        loadHeadersFromResource(R.xml.settings_preference, target);
    }

    // 监听改变
    @Override
    protected void onResume() {
        super.onResume();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        preferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        System.out.println("更改了：" + key);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }
}
