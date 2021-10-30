package com.sample.twitterapplication.model

import com.google.gson.annotations.SerializedName

data class Tweet(
        @SerializedName("id")
        var id : Long,
        @SerializedName("text")
        var text : String,
        @SerializedName("user")
        var user : User,
        @SerializedName("retweet_count")
        var retweetCount : Long,
        @SerializedName("favorite_count")
        var favoriteCount : Long,
        @SerializedName("created_at")
        var createdAt : String
)