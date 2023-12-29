package com.example.praktikum12.ui.home.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.praktikum12.navigation.DestinasiNavigasi
import com.example.praktikum12.ui.home.viewmodel.EditViewModel
import  androidx.lifecycle.viewmodel.compose.viewModel
import com.example.praktikum12.ui.TopAppBarKontak
import com.example.praktikum12.ui.home.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

object EditDestination : DestinasiNavigasi {
    override val route = "Edit"
    override val titleRes = "Edit Kontak"
    const val kontakId = "itemId"
    val routeWithArgs = "$route/{$kontakId}"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
    ){
    val coroutineScope = rememberCoroutineScope()
    Scaffold (
        topBar = {
            TopAppBarKontak(
                title = DestinasiHome.titleRes ,
                canNavigateBack =true,
                navigateUp = navigateBack
            )
        },
        modifier = Modifier
    ){
        innerPadding ->
        EntryKontakBody(
            insertUiState = viewModel.editKontakState,
            onSiswaValueChange = viewModel::updateInsertKontakState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateKontak()
                    onNavigateUp()
                }
            },
            modifier = Modifier.padding(innerPadding)
            )
    }
}