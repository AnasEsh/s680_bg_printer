package com.example.print_from_image

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApp:Application() {
    companion object {
        val CHANNEL_ID="BLUETOOTH_PRINTER_APP";
        val CHANNEL_NAME="BLUETOOTH_PRINTER_APP_NOTI_CHANNEL";
    }
    override fun onCreate() {
        super.onCreate()
        _createNotificationsChannel();
    }

    private fun _createNotificationsChannel() {
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.O)
            return;
        val mgr:NotificationManager= getSystemService(NOTIFICATION_SERVICE) as NotificationManager;
        val channel=NotificationChannel(MyApp.CHANNEL_ID,MyApp.CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        mgr.createNotificationChannel(channel);
    }
}