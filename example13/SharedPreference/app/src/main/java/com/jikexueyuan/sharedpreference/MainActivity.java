package com.jikexueyuan.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY = "MyValue";
    private EditText etInput;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getPreferences(MODE_PRIVATE);
        editor = preferences.edit();

        etInput = (EditText) findViewById(R.id.etInput);

        findViewById(R.id.btnWrite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(KEY, etInput.getText().toString());
                if (editor.commit()) {
                    Toast.makeText(getApplicationContext(), "写入成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = preferences.getString(KEY, "当前数值不存在");
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
