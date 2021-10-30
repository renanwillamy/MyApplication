package com.sample.twitterapplication.utils

import android.content.Context
import com.sample.twitterapplication.api.retrofit.AuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {

        /** Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         */
        fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.twitter.com/1.1/search/")
                .client(OkHttpClient.Builder()
                    .addInterceptor(AuthInterceptor())
                    .build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}