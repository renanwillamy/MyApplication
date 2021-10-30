package com.sample.twitterapplication.api.retrofit

import com.sample.twitterapplication.utils.API_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor to add auth token to requests
 */
class AuthInterceptor() : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader("Authorization", "Bearer $API_TOKEN")

        return chain.proceed(requestBuilder.build())
    }
}