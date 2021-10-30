package com.sample.twitterapplication.api

import com.sample.twitterapplication.model.Statuses
import com.sample.twitterapplication.utils.RESULT_TYPE_QUERY
import com.sample.twitterapplication.utils.SEARCH_QUERY
import com.sample.twitterapplication.utils.SEARCH_TWEET_PATH
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {

    @GET(SEARCH_TWEET_PATH)
    fun getPosts(@Query(SEARCH_QUERY) query: String, @Query(RESULT_TYPE_QUERY) resultType: String) : Call<Statuses>
}