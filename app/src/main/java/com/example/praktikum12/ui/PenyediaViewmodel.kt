package com.example.praktikum12.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum12.KontakAplication
import com.example.praktikum12.ui.home.Viewmodel.HomeViewModel
import com.example.praktikum12.ui.home.Viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiKontak().container.KontakRepository)
        }
        initializer {
            InsertViewModel(aplikasiKontak().container.KontakRepository)
        }
    }
}

fun CreationExtras.aplikasiKontak(): KontakAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakAplication)