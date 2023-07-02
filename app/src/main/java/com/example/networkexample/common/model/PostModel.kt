package com.example.networkexample.common.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PostModel(
    @Json(name = "posts") val posts: List<Post>,
    @Json(name = "total") val total: Int,
    @Json(name = "skip") val skip: Int,
    @Json(name = "limit") val limit: Int,
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Post(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "body") val body: String,
    @Json(name = "userId") val userId: Int,
    @Json(name = "tags") val tags: List<String>,
    @Json(name = "reactions") val reactions: Int
) : Parcelable
