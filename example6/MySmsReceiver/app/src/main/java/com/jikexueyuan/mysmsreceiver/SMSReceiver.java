package com.jikexueyuan.mysmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by dej on 2016/9/25.
 */
public class SMSReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("短信已经接收到了");

        Bundle extras = intent.getExtras();
        if (extras == null)
            return;

        Object[] pdus = (Object[]) extras.get("pdus");

        for (int i = 0; i < pdus.length; i++) {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
            String fromAddress = message.getOriginatingAddress();

            System.out.format("发送者：%s, 信息内容：%s\n", fromAddress, message.getMessageBody());
        }
    }
}
