package com.example.print_from_image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.util.Base64

object DataTransformer {
    fun sepratedStringLinesToList(commaSeprated:String):List<String>{
        return commaSeprated.split("(-,-)");
    }
    fun base64StringToBitmap(encoded64:String):Bitmap{
        val bArray= Base64.getDecoder().decode(encoded64);
        val image= BitmapFactory.decodeByteArray(bArray,0,bArray.size);
        return  image;
    }
}