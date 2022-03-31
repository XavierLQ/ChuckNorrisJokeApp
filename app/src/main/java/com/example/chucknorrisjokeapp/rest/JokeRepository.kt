package com.example.chucknorrisjokeapp.rest

import android.util.Log
import com.example.chucknorrisjokeapp.model.JokeItem
import com.example.chucknorrisjokeapp.model.JokeList
import com.example.chucknorrisjokeapp.model.Jokes
import retrofit2.Response

interface JokeRepository {
    suspend fun getJoke(exclude:String):Response<Jokes>
    suspend fun getManyJokes(exclude:String):Response<JokeList>
    suspend fun getJokeWithCustomName(firstName:String,lastName:String,exclude:String):Response<Jokes>
}

class JokeRepoImplementation(private val jokeService:JokeAPI): JokeRepository{
    override suspend fun getJoke(exclude:String):Response<Jokes> =
        jokeService.getJoke(exclude)
    override suspend fun getManyJokes(exclude:String):Response<JokeList> =
        jokeService.getManyJokes(exclude)
    override suspend fun getJokeWithCustomName(firstName:String, lastName:String, exclude:String):Response<Jokes> =
        jokeService.getJokeWithCustomName(firstName,lastName,exclude)
}