package com.example.praktikum12.repositori


import com.example.praktikum12.model.Kontak
import com.example.praktikum12.service_api.KontakService


interface KontakRepository {
    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}