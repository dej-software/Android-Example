package com.jikexueyuan.anotherapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jikexueyuan.startservicefromanotherapp.IAppServiceRemoteBinder;
import com.jikexueyuan.startservicefromanotherapp.ITimerServiceCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent serviceIntent;
    private EditText etInput;
    private TextView tvCallbackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.jikexueyuan.startservicefromanotherapp", "com.jikexueyuan.startservicefromanotherapp.AppService"));

        etInput = (EditText) findViewById(R.id.etInput);
        tvCallbackText = (TextView) findViewById(R.id.tvCallbackText);

        findViewById(R.id.btnStartAppService).setOnClickListener(this);
        findViewById(R.id.btnStopAppService).setOnClickListener(this);
        findViewById(R.id.btnBindAppService).setOnClickListener(this);
        findViewById(R.id.btnUnbindAppService).setOnClickListener(this);
        findViewById(R.id.btnSync).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartAppService:
                startService(serviceIntent);
                break;
            case R.id.btnStopAppService:
                stopService(serviceIntent);
                break;
            case R.id.btnBindAppService:
                bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindAppService:
                callUnRegistBinder();
                unbindService(this);
                binder = null;
                break;
            case R.id.btnSync:
                if (binder != null) {
                    try {
                        binder.setData(etInput.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("Bind Service");
        System.out.println(service);

        binder = IAppServiceRemoteBinder.Stub.asInterface(service);
        try {
            binder.registCallback(onServiceCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        callUnRegistBinder();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        callUnRegistBinder();
    }

    private void callUnRegistBinder() {
        try {
            binder.unRegistCallback(onServiceCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private ITimerServiceCallback.Stub onServiceCallback = new ITimerServiceCallback.Stub() {
        @Override
        public void onTimer(int numIndex) throws RemoteException {
            Message msg = new Message();
            msg.obj = MainActivity.this;
            msg.arg1 = numIndex;
            handler.sendMessage(msg);
        }
    };

    private final MyHandler handler = new MyHandler();

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            int index = msg.arg1;
            MainActivity _this = (MainActivity) msg.obj;
            _this.tvCallbackText.setText("这是回调回服务器端的数据：" + index);
        }
    }

    private IAppServiceRemoteBinder binder = null;
}
