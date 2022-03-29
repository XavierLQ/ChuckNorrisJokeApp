package com.example.chucknorrisjokeapp.viewmodel

sealed interface JokeLoadingState {

    object LOADING : JokeLoadingState
    class SUCCESS<T>(response: T): JokeLoadingState
    class ERROR(val error:Throwable):JokeLoadingState

}