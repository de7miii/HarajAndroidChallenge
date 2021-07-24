package com.example.harajtask

import android.content.Context
import java.io.IOException

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