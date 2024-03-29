package com.shubham.newsapp.Api

import com.shubham.newsapp.Utils.Constants.Companion.NEWS_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(NEWS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val getInstance by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}