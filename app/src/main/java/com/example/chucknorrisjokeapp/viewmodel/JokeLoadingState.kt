package com.example.chucknorrisjokeapp.viewmodel

sealed class JokeLoadingState {

    object LOADING : JokeLoadingState()
    class SUCCESS<T>(val response: T): JokeLoadingState()
    class ERROR(val error:Throwable):JokeLoadingState()

}