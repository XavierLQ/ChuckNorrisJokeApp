package com.example.chucknorrisjokeapp.di

import com.example.chucknorrisjokeapp.rest.JokeAPI
import com.example.chucknorrisjokeapp.rest.JokeRepoImplementation
import com.example.chucknorrisjokeapp.rest.JokeRepository
import com.google.gson.Gson

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {

    fun providesOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    fun providesNetworkService(okHttpClient: OkHttpClient) =
        Retrofit.Builder().baseUrl(JokeAPI.BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
            .create(JokeAPI::class.java)


    fun providesJokeRepository(jokeRepository: JokeAPI): JokeRepository =
        JokeRepoImplementation(jokeRepository)

    single { providesOkHttpClient() }
    single { providesJokeRepository(get()) }
    single { providesNetworkService(get()) }
}