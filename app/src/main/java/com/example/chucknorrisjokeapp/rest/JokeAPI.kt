package com.example.chucknorrisjokeapp.rest

import com.example.chucknorrisjokeapp.model.JokeCount
import com.example.chucknorrisjokeapp.model.JokeItem
import com.example.chucknorrisjokeapp.model.Jokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeAPI {

    @GET(SingleJokeURL)
    suspend fun getJoke(
        @Query("exclude") Explicit:String
    ): Response<JokeItem>

    @GET(MultipleJokeURL)
    suspend fun getManyJokes(
        @Query("exclude") Explicit:String
    ): Response<Jokes>

    @GET(SingleJokeURL)
    suspend fun getJokeWithCustomName(
        @Query("firstName") firstName:String,
        @Query("lastName") lastName:String,
        @Query("exclude") Explicit:String
    ): Response<JokeItem>

    @GET(JokeCountURL)
    suspend fun getJokeCount(): Response<JokeCount>

    companion object{

        val BaseURL = "http://api.icndb.com/jokes"

        const val SingleJokeURL = "/random"
        const val MultipleJokeURL = "random/4"
        const val JokeCountURL = "/count"

    }
}