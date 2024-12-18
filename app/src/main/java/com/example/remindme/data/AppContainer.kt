package com.example.remindme.data

import android.content.Context

interface Container {
    val reminderDatabaseRepository: ReminderDatabaseRepository
}

class AppContainer(context: Context) : Container {

    override val reminderDatabaseRepository by lazy {
        ReminderDatabaseRepository(ReminderDatabase.getDatabase(context).dao())
    }

}