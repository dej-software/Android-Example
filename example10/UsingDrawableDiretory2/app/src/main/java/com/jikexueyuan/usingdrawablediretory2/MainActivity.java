package com.jikexueyuan.usingdrawablediretory2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //    private ImageButton imgBtn;
//    private ImageView imageView;
//    private ClipDrawable clipDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        imgBtn = (ImageButton) findViewById(R.id.imgBtn);
//        final TransitionDrawable drawable = (TransitionDrawable) imgBtn.getDrawable();
//
//        imgBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawable.startTransition(1000);
//            }
//        });

//        imageView = (ImageView) findViewById(R.id.image);
//        clipDrawable = (ClipDrawable) imageView.getDrawable();
////        clipDrawable.setLevel(1000);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                isRun = true;
//                try {
//                    while (isRun) {
//                        Thread.sleep(1000);
//                        handler.sendEmptyMessage(0);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();

//        imageView = (ImageView) findViewById(R.id.my_scale_drawable_image);
//        ScaleDrawable scaleDrawable = (ScaleDrawable) imageView.getDrawable();
//        scaleDrawable.setLevel(1);
    }

//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            clipDrawable.setLevel(clipDrawable.getLevel() + 1000);
//            if (clipDrawable.getLevel() + 1000 >= 10000) {
//                isRun = false;
//            }
//        }
//    };
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        isRun = false;
//    }
//
//    private boolean isRun;
}
