package com.example.remindme

import android.app.Application
import com.example.remindme.data.ReminderDatabase
import com.example.remindme.data.ReminderDatabaseRepositoryImpl

class RemindMeApp: Application() {

    private lateinit var reminderDatabase: ReminderDatabase
    lateinit var reminderDatabaseRepositoryImpl: ReminderDatabaseRepositoryImpl

    override fun onCreate() {
        super.onCreate()
        reminderDatabase = ReminderDatabase.getDatabase(this)
        reminderDatabaseRepositoryImpl = ReminderDatabaseRepositoryImpl(reminderDatabase.dao())
    }

}