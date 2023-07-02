package com.example.networkexample.common.network

class ApiClient(private val apiServices: ApiServices) : BaseApiClient() {

    suspend fun getAllPosts() = getResult {
        apiServices.getAllPosts()
    }

    suspend fun getAllUsers() = getResult {
        apiServices.getAllUsers()
    }

}