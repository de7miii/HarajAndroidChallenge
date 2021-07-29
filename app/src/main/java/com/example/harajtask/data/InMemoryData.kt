package com.example.harajtask.data

import android.content.Context
import android.util.Log
import com.example.harajtask.models.Post
import com.example.harajtask.getJsonString
import org.json.JSONArray
import org.json.JSONTokener

const val TAG = "InMemoryData"

class InMemoryData : IData {

    // converts the data from a json string into a list of posts
    // based on the known fact that the data.json file contains an array of
    // json objects
    override fun getAllPosts(context: Context): List<Post> {
        val jsonString = getJsonString(context, "data.json")
        val jsonArray = JSONTokener(jsonString).nextValue() as JSONArray
        val postsList = mutableListOf<Post>()
        for(i in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(i)
            Log.i(TAG, "loadData: ${jsonObject.getString("title")}" )
            postsList.add(Post.fromJson(jsonObject))
        }
        return postsList
    }
}