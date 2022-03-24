package com.example.chucknorrisjokeapp.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.chucknorrisjokeapp.model.JokeItem

interface JokeDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<JokeItem>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<JokeItem>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): JokeItem

    @Insert
    fun insertAll(vararg users: JokeItem)

    @Delete
    fun delete(user: JokeItem)



}