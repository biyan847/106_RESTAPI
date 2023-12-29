package com.example.praktikum12.repositori

import com.example.praktikum12.service_api.KontakService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val kontakRepositori : KontakRepositori
}
class KontakContainer : AppContainer{
    private val baseUrl = "http://10.0.2.2:8080/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
    private  val kontakservice: KontakService by lazy {
        retrofit.create(KontakService::class.java)

    }
    override val kontakRepositori: KontakRepositori by lazy {
        NetworkKontakRepository(kontakservice)
    }
}