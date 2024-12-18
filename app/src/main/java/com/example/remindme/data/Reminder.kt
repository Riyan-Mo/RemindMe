package com.example.remindme.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(tableName = "reminder")
data class Reminder (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String = "",
    var due: LocalTime = LocalTime.now(),
    val type: Type = Type.ONE_TIME,
    val on: Boolean = true
){
    fun getTime():String {
        var hour = due.hour
        var meridian = "AM"
        if(due.hour>12) {
            hour = due.hour - 12
            meridian = "PM"
        }
        val timeString = "${hour}:${due.minute} $meridian"
        return timeString
    }
}