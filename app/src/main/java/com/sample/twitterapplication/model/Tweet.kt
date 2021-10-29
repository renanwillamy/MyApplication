package com.sample.twitterapplication.model

class Tweet() {
    lateinit var userName: String
    lateinit var text: String
    lateinit var screenName: String

    constructor(userName: String, text: String) : this() {
        this.userName = userName
        this.text = text
    }

}