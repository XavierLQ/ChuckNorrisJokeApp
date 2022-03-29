package com.example.chucknorrisjokeapp.di

import android.app.Application
import android.content.Context
import com.example.chucknorrisjokeapp.database.JokeDao
import com.example.chucknorrisjokeapp.database.JokeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Singleton
    @Provides
    fun getJokeDao(jokeDatabase:JokeDatabase):JokeDao{
        return jokeDatabase.getJokeDao()
    }

    @Singleton
    @Provides
    fun getRoomInstance():JokeDatabase{
        return JokeDatabase.getDatabaseInstance(provideContext())
    }

    @Singleton
    @Provides
    fun provideContext(): Context {
        return application.applicationContext
    }



}