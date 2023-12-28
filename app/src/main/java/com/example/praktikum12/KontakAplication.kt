package com.example.praktikum12

import android.app.Application
import com.example.praktikum12.repositori.AppContainer
import com.example.praktikum12.repositori.KontakContainer

class KontakAplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate(){
        super.onCreate()
        container = KontakContainer()
    }
}