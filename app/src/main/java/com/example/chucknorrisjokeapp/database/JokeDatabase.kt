package com.example.chucknorrisjokeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class JokeDatabase : RoomDatabase() {


    companion object {
        private var dbInstance: JokeDatabase? = null

        fun getDatabaseInstance(context: Context): JokeDatabase {
            if (dbInstance == null) {

                dbInstance = Room.databaseBuilder(context,
                    JokeDatabase::class.java, "Joke_Database")
                    .build()
            }

            return dbInstance!!

        }
    }
}

