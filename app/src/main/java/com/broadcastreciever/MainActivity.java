package com.broadcastreciever;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.BroadcastRecieverClass;

public class MainActivity extends AppCompatActivity {


    BroadcastRecieverClass mReceiver = new BroadcastRecieverClass();
    BroadcastReceiver mBatteryReceiver;
    private Button mBatteryButton, mBluetoothButton;
    private TextView mBatteryText, mBluetoothText;
    private BluetoothBCReciever mBluetoothReceiver = new BluetoothBCReciever();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBroadcastReciever();
        mBatteryText = findViewById(R.id.mStatusText);
        mBluetoothText = findViewById(R.id.mBluetoothStatus);
        mBatteryButton = findViewById(R.id.mBatteryStatus);
        mBluetoothButton = findViewById(R.id.mBluetoothbtn);
        mBatteryButton.setOnClickListener(this::checkBatteryStatus);
        mBluetoothButton.setOnClickListener(this::checkBluetooth);
        mBluetoothButton.setEnabled(true);

    }

    private void setupBroadcastReciever() {
        mBatteryReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {

                    int batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                    int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                    float batterypercentage = batteryLevel * 100 / (float) scale;
                    mBatteryText.setText(batterypercentage + "%");
                    if (batterypercentage < 20.0f) {
                        Toast.makeText(context, "Battery is Below 20%", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Battery is at " + batterypercentage + "%", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
        unregisterReceiver(mBatteryReceiver);
        unregisterReceiver(mBluetoothReceiver);
    }

    public void checkBatteryStatus(View view) {
        registerReceiver(mBatteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    public void checkBluetooth(View view) {
            IntentFilter filter1 = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBluetoothReceiver, filter1);


    }


    public void checkInternetConnectivity(View view) {
        IntentFilter mFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, mFilter);
    }
}

