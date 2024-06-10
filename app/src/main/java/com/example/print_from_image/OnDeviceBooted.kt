package com.example.print_from_image

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class OnDeviceBooted:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        println("OnDeviceBooted receiver")
        println("context is null? ${context==null}");
        println("intent is null? ${intent==null}");
        if (intent==null|| (!intent.action.equals(Intent.ACTION_BOOT_COMPLETED)))
            return;
        println("Detected bootup intent");
    context?.startForegroundService(Intent(context,BluetoothHostService::class.java));
    }
}