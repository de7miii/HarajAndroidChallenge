package com.example.harajtask.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject

@Parcelize
data class Post(
    val title: String,
    val username: String,
    val thumbUrl: String,
    var commentCount: Int,
    val city: String,
    val timestamp: Long,
    val body: String
): Parcelable {
    companion object {
        fun fromJson(json: JSONObject): Post {
            return Post(
                title = json.getString("title"), username = json.getString("username"),
                thumbUrl = json.getString("thumbURL"), commentCount = json.getInt("commentCount"),
                city = json.getString("city"), timestamp = json.getLong("date"),
                body = json.getString("body")
            )
        }
    }
}