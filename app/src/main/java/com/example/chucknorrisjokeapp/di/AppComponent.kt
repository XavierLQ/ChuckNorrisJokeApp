package com.example.chucknorrisjokeapp.di

import com.example.chucknorrisjokeapp.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(mainViewModel:MainViewModel)
}