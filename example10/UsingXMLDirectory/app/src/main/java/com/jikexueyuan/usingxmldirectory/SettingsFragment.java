package com.jikexueyuan.usingxmldirectory;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

/**
 * Created by dej on 2016/10/15.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.setDefaultValues(getActivity(), R.xml.settings_preference, false);
    }

    public static class notificationFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            System.out.println("notificationFragment");
            System.out.println(getArguments().get("notifications"));

            addPreferencesFromResource(R.xml.settings_notification);
        }
    }

    public static class notificationTimeFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            System.out.println("notificationTimeFragment");
            System.out.println(getArguments().get("time"));

            addPreferencesFromResource(R.xml.settings_notification_time);
        }
    }
}
