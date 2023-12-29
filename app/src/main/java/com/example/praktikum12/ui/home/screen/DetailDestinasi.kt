package com.example.praktikum12.ui.home.screen

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktikum12.model.Kontak
import com.example.praktikum12.navigation.DestinasiNavigasi

object DetailDestinasi : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = "Detail Kontak"
    const val kontakId = "itemId"
    val routeWithArgs = "$route/{$kontakId}"
}
@Composable
fun KontakCard(
    kontak: Kontak,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = kontak.nama,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null)
                Text(
                    text =kontak.telpon,
                    style = MaterialTheme.typography.titleMedium)
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = kontak.alamat,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.weight(1f))

            }


        }

    }
}

