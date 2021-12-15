package com.example.tpfinal

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts/")
    fun getAllPost(): Call<List<Post>>

}