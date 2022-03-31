package com.example.chucknorrisjokeapp.di

import com.example.chucknorrisjokeapp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
}