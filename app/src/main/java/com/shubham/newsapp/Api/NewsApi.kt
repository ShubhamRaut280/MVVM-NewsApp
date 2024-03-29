package com.shubham.newsapp.Api

import com.shubham.newsapp.Models.api.NewsResponse
import com.shubham.newsapp.Utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country")
        CountryCode: String = "in",
        @Query("page")
        PageNumber :Int = 1,
        @Query("apiKey")
        apiKey:String = API_KEY
   ):Response<NewsResponse>


    @GET("v2/everything")
    suspend fun SearchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        PageNumber :Int = 1,
        @Query("apiKey")
        apiKey:String = API_KEY
    ):Response<NewsResponse>
}