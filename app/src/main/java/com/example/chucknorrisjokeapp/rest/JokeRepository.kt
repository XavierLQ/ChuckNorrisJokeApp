package com.example.chucknorrisjokeapp.rest

import com.example.chucknorrisjokeapp.model.JokeItem
import com.example.chucknorrisjokeapp.model.Jokes
import retrofit2.Response

interface JokeRepository {
    suspend fun getJoke(Explicit:String):Response<JokeItem>
    suspend fun getManyJokes(explicit:String):Response<List<JokeItem>>
    suspend fun getJokeWithCustomName(firstName:String,lastName:String,Explicit:String):Response<JokeItem>
}

class JokeRepoImplementation(val jokeService:JokeAPI){

    suspend fun getJoke(explicit:String):Response<JokeItem>{
        return jokeService.getJoke(explicit)
    }
    suspend fun getManyJokes(explicit:String):Response<List<JokeItem>>{
        return jokeService.getManyJokes(explicit)
    }
    suspend fun getJokeWithCustomName(firstName:String,lastName:String,explicit:String):Response<JokeItem>{
        return jokeService.getJokeWithCustomName(firstName,lastName,explicit)
    }
}