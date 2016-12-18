package com.jikexueyuan.usingfingerprint;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private KeyguardManager keyguardManager;
    private Button btnBuy;
    private FingerprintManager fingerprintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuy = (Button) findViewById(R.id.btnBuy);

        keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (!keyguardManager.isKeyguardSecure()) {
                showMessage("屏幕锁没有创建，请前往‘设置 -> 安全 -> 屏幕锁定方式’设置一个锁定方式");
                btnBuy.setEnabled(false);
                return;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                if (!fingerprintManager.hasEnrolledFingerprints()) {
                    showMessage("当前手机没有指纹，请前往‘设置 -> 安全 -> 指纹’添加至少一个指纹");
                    btnBuy.setEnabled(false);
                    return;
                }
            }
        }
    }

    private void showMessage(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
