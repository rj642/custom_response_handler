package com.example.networkexample.common.network

import com.example.networkexample.common.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET("posts")
    suspend fun getAllPosts(): Response<PostModel>

    /**
     * Skip post with id 12, as its having some malformed key-value pairs
     */
    @GET("users?skip=12&limit=50")
    suspend fun getAllUsers(): Response<Map<String, String>> // TODO: Replace with response model class

}