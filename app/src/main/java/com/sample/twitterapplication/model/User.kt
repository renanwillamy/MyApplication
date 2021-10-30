package com.sample.twitterapplication.model

import com.google.gson.annotations.SerializedName

class User (
        @SerializedName("name")
        var name : String,
        @SerializedName("screen_name")
        var screenName : String,
        @SerializedName("profile_image_url_https")
        var profileImageUrl : String
)