package com.jikexueyuan.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

//        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        System.out.println("所有的传感器：");
//        for (Sensor s : sensorList) {
//            System.out.println(s.getName());
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 在onResume中注册
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

//        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // 在onPause中注销，程序在后台时不消耗传感器
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_PROXIMITY:
                System.out.println("距离传感器：" + event.values[0]);
                break;
            case Sensor.TYPE_ACCELEROMETER:
                System.out.println("加速度传感器：" + String.format("X=%f,Y=%f,X=%f", event.values[0], event.values[1], event.values[2]));
                break;
            case Sensor.TYPE_ORIENTATION:
                // 0代表手机头指向北
                System.out.println("指南针（方向）传感器：" + String.format("value=%f", event.values[0]));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
