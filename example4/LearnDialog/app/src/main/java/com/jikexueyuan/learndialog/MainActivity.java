package com.jikexueyuan.learndialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_normaldialog).setOnClickListener(this);
        findViewById(R.id.btn_listdialog).setOnClickListener(this);
        findViewById(R.id.btn_singlechoosedialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normaldialog:
                showNormalDialog();
                break;
            case R.id.btn_listdialog:
                showListDialog();
                break;
            case R.id.btn_singlechoosedialog:
                showSingleChooseDialog();
                break;
        }
    }

    private void showSingleChooseDialog() {
        final String[] sex = {"男", "女"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("单选对话框");
        builder.setSingleChoiceItems(sex, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "选择了" + sex[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    private void showListDialog() {
        final String[] colors = {"黑色", "白色", "红色"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("列表对话框");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "选择了" + colors[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    private void showNormalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("普通对话框");
        builder.setMessage("请选择确定按钮");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击了关闭按钮", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }
}
