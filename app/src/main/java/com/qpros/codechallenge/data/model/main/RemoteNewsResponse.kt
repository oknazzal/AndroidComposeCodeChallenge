package com.qpros.codechallenge.data.model.main

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class RemoteNewsResponse(

    @Json(name = "author")
    var author: String?,

    @Json(name = "title")
    var title: String,

    @Json(name = "description")
    var description: String,

    @Json(name = "url")
    var url: String,

    @Json(name = "urlToImage")
    var urlToImage: String?,

    @Json(name = "content")
    var content: String,

    @Json(name = "publishedAt")
    var publishedAt: String

    ):Parcelable
