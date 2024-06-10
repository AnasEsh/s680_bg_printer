package com.example.print_from_image

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class OnPrintRequested :BroadcastReceiver() {
    companion object{
        val IMAGE_PRINT_ACTION="com.example.printer_app.image"
        val LINES_PRINT_ACTION="com.example.printer_app.json_array"
    }
    override fun onReceive(context: Context?, intent: Intent?) {
    if(intent?.action==null||(!(intent.extras?.containsKey("data")?:false)))
        return;
    val data:String=intent.getStringExtra("data")!!;
    if(intent!!.action.equals(LINES_PRINT_ACTION)){
        PrinterService.printLines(
            DataTransformer.sepratedStringLinesToList(data)
        );
    }
    if(intent!!.action.equals(IMAGE_PRINT_ACTION)){
            PrinterService.fromBitMap(DataTransformer.base64StringToBitmap(data));
        }
    }
}