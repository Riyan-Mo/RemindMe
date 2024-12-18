package com.example.remindme.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {

    @Query("Select * from reminder ORDER BY due")
    fun getAllReminders(): Flow<List<Reminder>>

}