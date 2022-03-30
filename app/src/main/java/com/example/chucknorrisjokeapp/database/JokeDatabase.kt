package com.example.chucknorrisjokeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chucknorrisjokeapp.model.JokeItem

//@Database(entities = [JokeItem::class], version = 1)
//abstract class JokeDatabase : RoomDatabase() {
//
//    abstract fun getJokeDao(): JokeDao
//
//    companion object {
//
//        /*
//        * Object with function to create a single instance of the DB if not null
//         */
//
//        private var dbInstance: JokeDatabase? = null
//
//        fun getDatabaseInstance(context: Context): JokeDatabase {
//            if (dbInstance == null) {
//
//                dbInstance = Room.databaseBuilder(context,
//                    JokeDatabase::class.java, "Joke_Database")
//                    .build()
//            }
//
//            return dbInstance!!
//
//        }
//    }
//}

