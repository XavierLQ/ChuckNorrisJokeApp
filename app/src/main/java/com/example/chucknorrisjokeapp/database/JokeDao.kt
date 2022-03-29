package com.example.chucknorrisjokeapp.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chucknorrisjokeapp.model.JokeItem

interface JokeDao {

    @Query("SELECT * FROM JokeItemTable ORDER BY RANDOM()")
    suspend fun getAllJokesFromDB(): List<JokeItem>

    @Query("SELECT * FROM JokeItemTable ORDER BY RANDOM() LIMIT 1")
    suspend fun getOneJokeFromDB(): JokeItem

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllJokesToDB(vararg jokes: List<JokeItem>)

    @Delete
    suspend fun deleteJokesFromDB(user: JokeItem)

}