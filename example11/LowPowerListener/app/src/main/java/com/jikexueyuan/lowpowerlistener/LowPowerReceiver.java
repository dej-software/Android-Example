package com.jikexueyuan.lowpowerlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LowPowerReceiver extends BroadcastReceiver {
    public LowPowerReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        System.out.println("Low Power");
    }
}
