package com.example.remindme.data

import kotlinx.coroutines.flow.Flow

interface ReminderDatabaseInterface{
    fun getAllRemindersStream(): Flow<List<Reminder>>

    suspend fun insertReminder(reminder: Reminder): Unit
}

class ReminderDatabaseRepository(
    private val reminderDao: ReminderDao
): ReminderDatabaseInterface {
    override fun getAllRemindersStream(): Flow<List<Reminder>> {
        return reminderDao.getAllReminders()
    }

    override suspend fun insertReminder(reminder: Reminder) {
        reminderDao.insertReminder(reminder)
    }
}