package com.example.praktikum12.service_api

import com.example.praktikum12.model.Kontak
import retrofit2.http.GET
import retrofit2.http.Headers

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("kontak")
    suspend fun getKontak(): List<Kontak>
}