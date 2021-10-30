package com.sample.twitterapplication.model

import com.google.gson.annotations.SerializedName

data class Statuses (
    @SerializedName("statuses")
    var statuses : List<Tweet>
)