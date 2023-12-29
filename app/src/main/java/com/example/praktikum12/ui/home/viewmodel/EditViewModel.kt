package com.example.praktikum12.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum12.repositori.KontakRepositori
import com.example.praktikum12.ui.home.screen.EditDestination
import kotlinx.coroutines.launch

class EditViewModel (
    savedStateHandle: SavedStateHandle,
    private val kontakRepositori: KontakRepositori
): ViewModel(){
    var editKontakState by mutableStateOf(InsertUiState())
        private set
    var kontakId: Int = checkNotNull(savedStateHandle[EditDestination.kontakId])

    init {
        viewModelScope.launch {
            editKontakState = kontakRepositori.getKontakById(kontakId).toUiStateKontak()
        }
    }
    fun updateInsertKontakState(insertUiEvent: InsertUiEvent){
        editKontakState = InsertUiState(insertUiEvent=insertUiEvent)
    }
    suspend fun  updateKontak(){
        viewModelScope.launch {
            try {
                kontakRepositori.updateKontak(kontakId, editKontakState.insertUiEvent.toKontak())

            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}