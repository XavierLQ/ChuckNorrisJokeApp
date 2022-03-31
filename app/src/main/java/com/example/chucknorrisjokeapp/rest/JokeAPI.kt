package com.example.chucknorrisjokeapp.rest

import com.example.chucknorrisjokeapp.model.JokeItem
import com.example.chucknorrisjokeapp.model.JokeList
import com.example.chucknorrisjokeapp.model.Jokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeAPI {

    //http://api.icndb.com/jokes/random?exclude=
    @GET(SingleJokeURL)
    suspend fun getJoke(
        @Query("exclude") Explicit:String
    ): Response<Jokes>

    //http://api.icndb.com/jokes/random/4
    @GET(MultipleJokeURL)
    suspend fun getManyJokes(
        @Query("exclude") Explicit:String
    ): Response<JokeList>

    //http://api.icndb.com/jokes/random?firstName=John&lastName=Doe&exclude=
    @GET(SingleJokeURL)
    suspend fun getJokeWithCustomName(
        @Query("firstName") firstName:String,
        @Query("lastName") lastName:String,
        @Query("exclude") Explicit:String
    ): Response<Jokes>


    companion object{

        const val BaseURL = "https://api.icndb.com/"
        const val SingleJokeURL = "jokes/random"
        const val MultipleJokeURL = "jokes"

    }
}