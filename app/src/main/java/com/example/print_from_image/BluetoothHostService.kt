package com.example.print_from_image

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.app.NotificationCompat


class BluetoothHostService : Service() {

    override fun onCreate() {
        super.onCreate()
    }

    private fun _showNotificaiton() {
        println("Pushing notification123");
        val mgr:NotificationManager=getSystemService(NotificationManager::class.java);
        //heeeeeeeeeeeeeeeeeeeeeeeeeeeere send the notification and see what will happend
        val noti=NotificationCompat.Builder(applicationContext,MyApp.CHANNEL_ID)
            .setContentTitle("Bluetooth Ready to print from service")
            .setContentText("Bluetooth Ready to print")
            .setColor(Color.Cyan.toArgb());
        startForeground(1,noti.build());
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        _showNotificaiton();
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null;
    }

}