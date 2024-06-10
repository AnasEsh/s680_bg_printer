package com.example.print_from_image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Parcel
import android.os.Parcelable
import com.trendit.basesdk.POSDeviceManager
import com.trendit.basesdk.device.printer.OnPrintTaskListener
import com.trendit.basesdk.device.printer.format.BitmapFormat
import com.trendit.basesdk.device.printer.format.PrintAlign
import com.trendit.basesdk.device.printer.format.PrintDensity
import com.trendit.basesdk.device.printer.format.TextFormat
import java.util.Base64

object PrinterService {
    lateinit var headingFormat: TextFormat;
    lateinit var leftBodyFormat: TextFormat;
    lateinit var rightBodyFormat: TextFormat;
    lateinit var centerBodyFormat: TextFormat;
    init {
        setHeadingFormat();
        setRowLeftFormat();
        setRowCenterFormat()
        setRowRightFormat();
    }

    public fun printLines(lines:List<String>):Unit{
        POSDeviceManager.getInstance().printerDevice.apply {

            this.printDensity= PrintDensity.FORMAT_DENSITY_DARKER;

            for(l in lines)
                printText(centerBodyFormat, "\n ${l} \n")
            printDottedLines(headingFormat,2);
            printText(headingFormat,"\n \n");

            startPrint(object: OnPrintTaskListener(){
                override fun onPrintResult(p0: Int) {
//                    PrinterConstants
                    println("Printing result ${p0}");
                }

            } );
        };
    }

    public fun fromBitMap(image:Bitmap){

        POSDeviceManager.getInstance().printerDevice.apply {
            BitmapFormat.CREATOR.createFromParcel(Parcel.obtain().apply {

            });
            printText( headingFormat,"\n");
            printBitmap(BitmapFormat.CREATOR.createFromParcel(Parcel.obtain()),image);
            printText( headingFormat,"\n\n");
            
            startPrint(
                object: OnPrintTaskListener(){
                    override fun onPrintResult(p0: Int) {

                    }
                }
            );
        }

    }

    public fun tstPrinter(){
        POSDeviceManager.getInstance().printerDevice.apply {

            this.printDensity= PrintDensity.FORMAT_DENSITY_DARKER;
            printText(headingFormat,"\n\nBeyond Technology\n\n\n");

            printText(headingFormat,"\n\nPrinter Test\n\n");

            printText(headingFormat,"\n\n \n\n");
            startPrint(object: OnPrintTaskListener(){
                override fun onPrintResult(p0: Int) {
//                    PrinterConstants
                    println("Printing result ${p0}");
                }

            } );
        };
    }
    private fun setHeadingFormat(){
        val format= TextFormat();
        format.fontSize=35;
        format.align= PrintAlign.FORMAT_ALIGN_CENTER;
        format.isBold=true;
        headingFormat=format;
    }
    private fun setRowLeftFormat(){
        val format= TextFormat();
        format.align= PrintAlign.FORMAT_ALIGN_LEFT;
        format.isBold=false;
        leftBodyFormat=format;
    }

    private fun setRowRightFormat(){
        val format= TextFormat();
        format.align= PrintAlign.FORMAT_ALIGN_RIGHT;
        format.isBold=false;
        rightBodyFormat=format;
    }
    private fun setRowCenterFormat(){
        val format= TextFormat();
        format.align= PrintAlign.FORMAT_ALIGN_RIGHT;
        format.isBold=false;
        centerBodyFormat=format;
    }
}