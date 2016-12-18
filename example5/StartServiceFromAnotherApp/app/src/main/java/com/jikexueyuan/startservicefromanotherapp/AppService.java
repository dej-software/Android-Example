package com.jikexueyuan.startservicefromanotherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

public class AppService extends Service {

    private RemoteCallbackList<ITimerServiceCallback> callbackList = new RemoteCallbackList<>();

    public AppService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new IAppServiceRemoteBinder.Stub() {

            @Override
            public void setData(String data) throws RemoteException {
                AppService.this.data = data;
            }

            @Override
            public void registCallback(ITimerServiceCallback callback) throws RemoteException {
                callbackList.register(callback);
            }

            @Override
            public void unRegistCallback(ITimerServiceCallback callback) throws RemoteException {
                callbackList.unregister(callback);
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service Started");

        new Thread() {
            @Override
            public void run() {
                super.run();

                running = true;
//                while (running) {
//
//                    System.out.println(data);
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                for (numIndex = 0; running; numIndex++) {

                    System.out.println(numIndex);

                    int count = callbackList.beginBroadcast();

                    while (count-- > 0) {
                        try {
                            callbackList.getBroadcastItem(count).onTimer(numIndex);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }

                    callbackList.finishBroadcast();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service Destroy");
        running = false;
    }

    private String data = "默认数据";
    private boolean running = false;
    private int numIndex = 0;
}
