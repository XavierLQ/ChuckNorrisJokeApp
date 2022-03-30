package com.example.chucknorrisjokeapp

import android.app.Application
import com.example.chucknorrisjokeapp.di.AppComponent
import com.example.chucknorrisjokeapp.di.AppModule
import com.example.chucknorrisjokeapp.di.DaggerAppComponent

class JokeApp: Application() {

    override fun onCreate() {
        super.onCreate()

        jokeComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var jokeComponent: AppComponent
    }
}