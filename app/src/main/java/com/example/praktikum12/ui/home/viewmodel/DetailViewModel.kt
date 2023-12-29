package com.example.praktikum12.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum12.model.Kontak
import com.example.praktikum12.repositori.KontakRepositori
import com.example.praktikum12.ui.home.screen.DetailDestinasi
import kotlinx.coroutines.launch

sealed class DetailsKontakUiState{
    data class Success(
        val kontak: Kontak) : DetailsKontakUiState()
    object Error : DetailsKontakUiState()
    object Loading : DetailsKontakUiState()
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val kontakRepositori: KontakRepositori
): ViewModel(){
    private val kontakId: Int = checkNotNull(savedStateHandle[DetailDestinasi.kontakId])

    var detailsKontakUiState: DetailsKontakUiState by mutableStateOf(DetailsKontakUiState.Loading)
    private set


    init {
        getKontakById()
    }

    fun getKontakById(){
        viewModelScope.launch {
            detailsKontakUiState = DetailsKontakUiState.Loading
            detailsKontakUiState = try {
                DetailsKontakUiState.Success(
                    kontak = kontakRepositori.getKontakById(kontakId)
                )
            } catch (e:Exception){
                DetailsKontakUiState.Error
            }
        }
    }
}