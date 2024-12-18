package com.example.remindme.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {

    @Query("Select * from reminder ORDER BY due")
    fun getAllReminders(): Flow<List<Reminder>>

    @Upsert
    fun insertReminder(reminder: Reminder)

}