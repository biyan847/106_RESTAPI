package com.example.praktikum12.ui.home.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum12.KontakAplication

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiKontak().container.kontakRepositori)
        }
        initializer {
            InsertViewModel(aplikasiKontak().container.kontakRepositori)
        }
        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                kontakRepositori = aplikasiKontak().container.kontakRepositori
            )
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                kontakRepositori = aplikasiKontak().container.kontakRepositori
            )
        }
    }
}

fun CreationExtras.aplikasiKontak(): KontakAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakAplication)