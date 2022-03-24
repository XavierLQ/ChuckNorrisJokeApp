package com.example.chucknorrisjokeapp.model


import com.google.gson.annotations.SerializedName

data class JokeCount(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: Int
)