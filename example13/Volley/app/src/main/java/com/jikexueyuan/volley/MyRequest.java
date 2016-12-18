package com.jikexueyuan.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;

/**
 * Created by dej on 2016/11/12.
 */
public class MyRequest<T> extends com.android.volley.Request<T> {

    private Priority priority;

    public MyRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Priority getPriority() {
        if (priority != null) {
            return priority;
        } else {
            return Priority.NORMAL;
        }
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(T response) {

    }
}
