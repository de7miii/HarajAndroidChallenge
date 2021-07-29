package com.example.harajtask.models

import android.os.Parcelable
import com.example.harajtask.getHumanizedDate
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

@Parcelize
data class Post(
    val title: String,
    val username: String,
    val thumbUrl: String,
    var commentCount: Int,
    val city: String,
    val timestamp: Long,
    val humanizedTime: String,
    val body: String
): Parcelable {
    companion object {
        fun fromJson(json: JSONObject): Post {
            return Post(
                title = json.getString("title"), username = json.getString("username"),
                thumbUrl = json.getString("thumbURL"), commentCount = json.getInt("commentCount"),
                city = json.getString("city"), timestamp = json.getLong("date"),
                body = json.getString("body"), humanizedTime = getHumanizedDate(json.getLong("date"))
            )
        }
        fun toJson(post: Post): JSONObject {
            return JSONObject("{\n" +
                    "        \"title\": \"${post.title}\",\n" +
                    "        \"username\": \"${post.username}\",\n" +
                    "        \"thumbURL\": \"${post.thumbUrl}\",\n" +
                    "        \"commentCount\": ${post.commentCount},\n" +
                    "        \"city\": \"${post.city}\",\n" +
                    "        \"date\": ${post.timestamp},\n" +
                    "        \"body\": \"${post.body}\"" +
                    "    }")
        }
    }
}