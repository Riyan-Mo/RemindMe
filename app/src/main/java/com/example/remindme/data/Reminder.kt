package com.example.remindme.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity(tableName = "reminder")
class Reminder (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    var due: String = LocalDateTime.now().toString(),
    val type: Type = Type.ONE_TIME,
    val on: Boolean = true
){
    fun dueToLocale(): LocalDateTime {
        return LocalDateTime.parse(due, DateTimeFormatter.ofPattern("HH:mm"))
    }

    companion object {
        fun dueToString(dt: LocalDateTime): String{
            return dt.format(DateTimeFormatter.ofPattern("HH:mm")).toString()
        }
    }

}