package com;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class BroadcastRecieverClass extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

            Toast.makeText(context, "Boot Completed", Toast.LENGTH_LONG).show();

        }


        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (!noConnectivity){
                Toast.makeText(context, "Conected to the Network", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Disconnectedl", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
