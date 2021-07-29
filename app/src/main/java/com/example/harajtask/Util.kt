package com.example.harajtask

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.net.toUri
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.net.URI
import java.util.*

// A helper function to convert the data file into a json string.
fun getJsonString(context: Context, filename: String): String? {
    var jsonString = ""
    try {
        jsonString = context.assets.open(filename).bufferedReader().use { it.readText() }
    }catch (ioException: IOException){
        ioException.printStackTrace()
        return null
    }
    return jsonString
}


const val SECOND = 1000
const val MINUTE = 60
const val HOUR = MINUTE * 60
const val DAY = 24

fun getHumanizedDate(timestamp: Long): String {
    var result = ""
    val currentTimeInSeconds = Date().time / SECOND
    var diff = (currentTimeInSeconds - timestamp).toInt()
    diff /= HOUR
    if(diff < 1) result = "Less than 1 hour ago"
    if(diff == 1) result = "1 hour ago"
    if(diff in 2..47) result = "$diff hours ago"
    if(diff > 48){
        diff /= DAY
        result = "$diff days ago"
    }
    return result
}