// IAppServiceRemoteBinder.aidl
package com.jikexueyuan.startservicefromanotherapp;

// Declare any non-default types here with import statements
import com.jikexueyuan.startservicefromanotherapp.ITimerServiceCallback;

interface IAppServiceRemoteBinder {

    void setData(String data);
    void registCallback(ITimerServiceCallback callback);
    void unRegistCallback(ITimerServiceCallback callback);
}
