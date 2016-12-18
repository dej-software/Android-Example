package com.jikexueyuan.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

public class MainActivity extends FinalActivity {

    @ViewInject(id = R.id.btnClick, click = "btnClick")
    private Button btnClick;

    @ViewInject(id = R.id.myTextView)
    private TextView myTextView;

    @ViewInject(id = R.id.btnLoadImg, click = "loadImage")
    private Button btnLoadImg;

    @ViewInject(id = R.id.iv_Img)
    private ImageView myImageView;

    private FinalBitmap finalBitmap;

    @ViewInject(id = R.id.btnSaveData, click = "saveData")
    private Button btnSaveData;

    private FinalDb finalDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        finalBitmap = FinalBitmap.create(this);
        finalDb = FinalDb.create(this);
    }

    public void btnClick(View view) {
//        myTextView.setText("极客学院");
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams params = new AjaxParams();
        params.put("a", "22");
        params.put("b", "33");
        finalHttp.get("http://10.0.2.2/test/index.php", params, new AjaxCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                myTextView.setText(s);
                super.onSuccess(s);
            }
        });
    }

    public void loadImage(View view) {
        System.out.println("loadImage");
        finalBitmap.display(myImageView, "http://tupian.enterdesk.com/2012/1029/zyz/03/14583115_1350966109847.jpg");
    }

    public void saveData(View view) {
        System.out.println("saveData");
        People people = new People("DD", 100);
        finalDb.save(people);
    }
}
