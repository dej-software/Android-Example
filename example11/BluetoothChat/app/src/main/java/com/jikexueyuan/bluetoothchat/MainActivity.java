package com.jikexueyuan.bluetoothchat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, BluetoothConnection.OnReadNewLineListener {

    private static final int REQUEST_ENABLE_BLUETOOTH = 1000;
    private BluetoothAdapter bluetoothAdapter;
    private ListView lvDevices;
    private DevicesListAdapter devicesListAdapter;
    private boolean scanning;
    private View viewProgress;
    private BluetoothConnection connection;
    private TextView tvOutput;
    private EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewProgress = findViewById(R.id.viewProgress);
        tvOutput = (TextView) findViewById(R.id.tvChatOutput);
        etInput = (EditText) findViewById(R.id.etChatInput);

        connection = new BluetoothConnection(this);
        connection.setOnReadNewLineListener(this);

        lvDevices = (ListView) findViewById(R.id.lvDevices);
        devicesListAdapter = new DevicesListAdapter(this, android.R.layout.simple_list_item_1);
        lvDevices.setAdapter(devicesListAdapter);
        lvDevices.setOnItemClickListener(this);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "您的设备不支持蓝牙", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            if (!bluetoothAdapter.isEnabled()) {
                requestEnableBluetooth();
            } else {
                // TODO
                loadBondedDevices();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        connection.startServerSocket();
    }

    @Override
    protected void onPause() {
        super.onPause();
        checkToStopScanDevices();
        connection.stopServerSocket();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_ENABLE_BLUETOOTH:
                switch (resultCode) {
                    case RESULT_OK:
                        // TODO
                        loadBondedDevices();
                        break;
                    default:
                        new AlertDialog.Builder(this).setTitle("提醒").setMessage("您拒绝启动蓝牙")
                                .setPositiveButton("再次启用", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        requestEnableBluetooth();
                                    }
                                })
                                .setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setCancelable(false)
                                .show();
                        break;
                }
                break;
        }
    }

    void requestEnableBluetooth() {
        Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(i, REQUEST_ENABLE_BLUETOOTH);
    }

    void loadBondedDevices() {
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        for (BluetoothDevice device : bondedDevices) {
            devicesListAdapter.add(new BluetoothDeviceWrapper(device));
        }
    }

    public void btnDiscoverableClicked(View view) {
        Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        i.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 120);
        startActivity(i);
    }

    public void btnStartScanClicked(View view) {
        checkToStartScanDevices();
    }

    public void btnStopScanClicked(View view) {
        checkToStopScanDevices();
    }

    private void checkToStartScanDevices() {
        if (!scanning) {
            registerReceiver(deviceFoundReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));
            bluetoothAdapter.startDiscovery();

            showProgress();

            scanning = true;
        }
    }

    private void checkToStopScanDevices() {
        if (scanning) {
            unregisterReceiver(deviceFoundReceiver);
            bluetoothAdapter.startDiscovery();

            hideProgress();

            scanning = false;
        }
    }

    void showProgress() {
        viewProgress.setVisibility(View.VISIBLE);
    }

    void hideProgress() {
        viewProgress.setVisibility(View.GONE);
    }

    private BroadcastReceiver deviceFoundReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            devicesListAdapter.add(new BluetoothDeviceWrapper(device));
        }
    };

    public void btnSendLineClicked(View view) {
        if (!TextUtils.isEmpty(etInput.getText())) {
            connection.sendLine(etInput.getText().toString());
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        connection.connect(devicesListAdapter.getItem(position).getDevice());
    }

    @Override
    public void onRead(final String line, final BluetoothDevice remoteDevice) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvOutput.append(remoteDevice.getName() + ":" + line + "\n");
            }
        });
    }
}
