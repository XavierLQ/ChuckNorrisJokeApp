package com.example.chucknorrisjokeapp.viewmodel

import android.app.Application
import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.*
import com.example.chucknorrisjokeapp.database.DatabaseRepository

import com.example.chucknorrisjokeapp.model.JokeItem
import com.example.chucknorrisjokeapp.rest.JokeAPI
import com.example.chucknorrisjokeapp.rest.JokeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel(
    private val jokeRepo : JokeRepository
    //private val dbRepo : DatabaseRepository
                    ): ViewModel() {

    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
    private val _jokeLiveData:MutableLiveData<JokeLoadingState> =
        MutableLiveData(JokeLoadingState.LOADING)

    val jokesLiveData: LiveData<JokeLoadingState> get() = _jokeLiveData

    fun getRandomJoke(explicit:String){

        //_jokeLiveData.postValue(JokeLoadingState.LOADING)
        viewModelScope.launch(coroutineDispatcher) {

            try{
                val response = jokeRepo.getJoke(explicit)
                if (response.isSuccessful){
                    response.body()?.let {
                        _jokeLiveData.postValue(JokeLoadingState.SUCCESS(it))
                    }?: throw Exception("no response from joke")

                    } else { throw Exception("response unsuccessful") }

            }
            catch(e: Exception){
                _jokeLiveData.postValue(JokeLoadingState.ERROR(e))
            }
        }
    }

    fun getCustomJoke(firstName:String, lastName:String, explicit:String){

        //_jokeLiveData.postValue(JokeLoadingState.LOADING)
        viewModelScope.launch(coroutineDispatcher) {

            try{
                val response = jokeRepo.getJokeWithCustomName(firstName, lastName, explicit)
                if (response.isSuccessful){
                    response.body()?.let {
                        _jokeLiveData.postValue(JokeLoadingState.SUCCESS(it))
                    }?: throw Exception("no response from joke")

                } else { throw Exception("response unsuccessful") }

            }
            catch(e: Exception){
                _jokeLiveData.postValue(JokeLoadingState.ERROR(e))
            }
        }
    }

    fun getMultipleJokes(explicit:String){

        //_jokeLiveData.postValue(JokeLoadingState.LOADING)
        viewModelScope.launch(coroutineDispatcher) {

            try{
                val response = jokeRepo.getManyJokes( explicit)
                if (response.isSuccessful){
                    response.body()?.let {
                        _jokeLiveData.postValue(JokeLoadingState.SUCCESS(it))
                    }?: throw Exception("no response from joke")

                } else { throw Exception("response unsuccessful") }

            }
            catch(e: Exception){
                _jokeLiveData.postValue(JokeLoadingState.ERROR(e))
            }
        }
    }
}