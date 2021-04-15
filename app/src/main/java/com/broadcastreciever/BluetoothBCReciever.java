package com.broadcastreciever;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BluetoothBCReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        final String action = intent.getAction();

        if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
            switch (state) {
                case BluetoothAdapter.STATE_OFF:
                    Toast.makeText(context, "Off", Toast.LENGTH_SHORT).show();
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    Toast.makeText(context, "Turning off", Toast.LENGTH_SHORT).show();

                    break;
                case BluetoothAdapter.STATE_ON:
                    Toast.makeText(context, "On", Toast.LENGTH_SHORT).show();
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    Toast.makeText(context, "Turning On", Toast.LENGTH_SHORT).show();

                    break;
            }

        }

    }
}
