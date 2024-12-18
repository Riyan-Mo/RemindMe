package com.example.remindme.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Entity(tableName = "reminder")
data class Reminder (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    var due: String = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")),
    val type: Type = Type.ONE_TIME,
    val on: Boolean = true
)