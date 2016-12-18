package com.jikexueyuan.xutils3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.tv_myText)
    private TextView textView;

    @ViewInject(R.id.iv_myImage)
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Event(value = R.id.btn_request)
    private void btnRequest(View view) {
//        System.out.println("btnRequest");
//        textView.setText("极客学院");
        RequestParams params = new RequestParams("http://10.0.2.2/test/index.php");
        params.addQueryStringParameter("a", "10");
        params.addQueryStringParameter("b", "32");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                textView.setText(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

        x.image().bind(imageView, "http://tupian.enterdesk.com/2012/1029/zyz/03/14583115_1350966109847.jpg");
    }
}
