package com.example.networkexample.common.repository

import com.example.networkexample.common.network.ApiClient

class MainRepo(private val apiClient: ApiClient): BaseRepo() {

    suspend fun getAllPosts() = makeRequest {
        apiClient.getAllPosts()
    }

    suspend fun getAllUsers() = makeRequest {
        apiClient.getAllUsers()
    }

}