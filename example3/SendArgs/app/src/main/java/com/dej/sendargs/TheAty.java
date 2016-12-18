package com.dej.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TheAty extends AppCompatActivity {

    private TextView tv;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_aty);

        Intent intent = getIntent();
//        Bundle data = intent.getExtras();

        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.editText);

//        tv.setText(intent.getStringExtra("data"));

//        tv.setText(String.format("name = %s, age = %d, test = %s",
//                data.getString("name"), data.getInt("age"), data.getString("test", "NULL")));

//        User user = (User) intent.getSerializableExtra("user");
        User user = (User) intent.getParcelableExtra("user");
        tv.setText(String.format("(name = %s, age = %d)", user.getName(), user.getAge()));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("data", et.getText().toString());
                setResult(1, i);
                finish();
            }
        });
    }
}
