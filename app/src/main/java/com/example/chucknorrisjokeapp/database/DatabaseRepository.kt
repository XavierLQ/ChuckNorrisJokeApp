package com.example.chucknorrisjokeapp.database

import com.example.chucknorrisjokeapp.model.JokeItem

interface DatabaseRepository {
    suspend fun getAllJokesFromDB(): List<JokeItem>
    suspend fun getOneJokeFromDB(): JokeItem
    suspend fun insertAllJokesToDB(vararg jokes: List<JokeItem>)
    suspend fun deleteJokesFromDB(user: JokeItem)
}

class DatabaseRepoImplementation(private val jokeDao: JokeDao){

    suspend fun getAllJokesFromDB(): List<JokeItem>{
        return jokeDao.getAllJokesFromDB()
    }
    suspend fun getOneJokeFromDB(): JokeItem{
        return jokeDao.getOneJokeFromDB()
    }
    suspend fun insertAllJokesToDB(vararg jokes: List<JokeItem>){
        return jokeDao.insertAllJokesToDB(*jokes)
    }
    suspend fun deleteJokesFromDB(user: JokeItem){
        return jokeDao.deleteJokesFromDB(user)
    }

}
