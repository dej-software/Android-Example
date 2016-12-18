package com.dej.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TheAty.class);
//                intent.putExtra("data", "Hello Android");

//                Bundle bundle = new Bundle();
//                bundle.putString("name", "jikexueyuan");
//                bundle.putInt("age", 20);
//                intent.putExtras(bundle);

                intent.putExtra("user", new User("jikexueyuan", 2));
//                startActivity(intent)
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        textView.setText("另一个Activity返回的数据是：" + data.getStringExtra("data"));
    }
}
