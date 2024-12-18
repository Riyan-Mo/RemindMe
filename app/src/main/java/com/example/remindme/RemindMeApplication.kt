package com.example.remindme

import android.app.Application
import com.example.remindme.data.AppContainer

class RemindMeApplication: Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }

}