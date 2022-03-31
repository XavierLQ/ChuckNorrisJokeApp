package com.example.chucknorrisjokeapp

import android.app.Application
import com.example.chucknorrisjokeapp.di.NetworkModule
import com.example.chucknorrisjokeapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JokeApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@JokeApp)
            modules(listOf(NetworkModule, viewModelModule))
        }
}}