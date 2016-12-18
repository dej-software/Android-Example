package com.jikexueyuan.androidasynchttp;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

/**
 * Created by dej on 2016/11/12.
 */
public class AsyncHttpClientManager {

    public static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String URL, RequestParams params, ResponseHandlerInterface handlerInterface) {
        client.get(URL, params, handlerInterface);
    }

    public static void get(String URL, ResponseHandlerInterface handlerInterface) {
        client.get(URL, handlerInterface);
    }
}
