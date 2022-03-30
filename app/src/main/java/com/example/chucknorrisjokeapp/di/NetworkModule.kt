package com.example.chucknorrisjokeapp.di

import com.example.chucknorrisjokeapp.rest.JokeAPI
import com.example.chucknorrisjokeapp.rest.JokeRepoImplementation
import com.example.chucknorrisjokeapp.rest.JokeRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun providesNetworkService(okHttpClient: OkHttpClient) =
        Retrofit.Builder().baseUrl(JokeAPI.BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
            .create(JokeAPI::class.java)

    @Provides
    @Singleton
    fun providesJokeRepository(jokeRepository: JokeAPI): JokeRepository =
        JokeRepoImplementation(jokeRepository)
//
//

}