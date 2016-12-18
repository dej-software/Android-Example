package com.jikexueyuan.bluetoothchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dej on 2016/10/17.
 */
public class DevicesListAdapter extends BaseAdapter {

    private final Context context;
    private final int cellResID ;
    private List<BluetoothDeviceWrapper> items = new ArrayList<>();

    public DevicesListAdapter(Context context, int cellResID) {
        this.context = context;
        this.cellResID = cellResID;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public BluetoothDeviceWrapper getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(cellResID, null);
        }

        assert convertView instanceof TextView;
        ((TextView) convertView).setText(getItem(position).toString());

        return convertView;
    }

    public void add(BluetoothDeviceWrapper bluetoothDeviceWrapper) {
        if (!items.contains(bluetoothDeviceWrapper)) {
            items.add(bluetoothDeviceWrapper);
            notifyDataSetChanged();
        }
    }
}
