package com.jikexueyuan.usinglayoutdirectory;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private People people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("onCreate");

        if (getLastCustomNonConfigurationInstance() != null) {
            // TODO 横竖屏切换
            people = (People) getLastCustomNonConfigurationInstance();
            System.out.println("last:" + people.getName() + " " + people.getAge());
        } else {
            initData();
        }
    }

    private void initData() {
        people = People.getPeople();
        people.setName("张三");
        people.setAge(25);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        System.out.println("onContentChanged");

        int mOrientation = getResources().getConfiguration().orientation;
        if (mOrientation == Configuration.ORIENTATION_PORTRAIT) {
            System.out.println("竖屏");
        } else if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            System.out.println("横屏");
        }
    }

    /**
     * 保存数据
     * @return
     */
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        System.out.println("onRetainCustomNonConfigurationInstance");
        people = People.getPeople();
        return people;
    }
}
