package com.example.chucknorrisjokeapp.di

import com.example.chucknorrisjokeapp.rest.JokeAPI
import com.example.chucknorrisjokeapp.rest.JokeRepoImplementation
import com.example.chucknorrisjokeapp.rest.JokeRepository
import com.example.chucknorrisjokeapp.viewmodel.MainViewModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {

    fun providesGson(): Gson = Gson()

    fun providesLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    fun providesNetworkService(gson: Gson, okHttpClient: OkHttpClient): JokeAPI =
        Retrofit.Builder().baseUrl(JokeAPI.BaseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient).build()
            .create(JokeAPI::class.java)


    fun providesJokeRepository(jokeRepository: JokeAPI): JokeRepository =
        JokeRepoImplementation(jokeRepository)

    single { providesLoggingInterceptor()}
    single { providesOkHttpClient(get()) }
    single { providesNetworkService(get(), get()) }
    single { providesJokeRepository(get()) }
    single { providesGson() }
}
val viewModelModule = module {

    viewModel { MainViewModel(get()) }
}