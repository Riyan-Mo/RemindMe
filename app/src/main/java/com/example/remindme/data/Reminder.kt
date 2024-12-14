package com.example.remindme.data

import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class Reminder (
    val title: String = "",
    var due: LocalTime = LocalTime.now(),
    val type: Type = Type.ONE_TIME,
    val on: Boolean = true
){
    fun getTime():String {
        return due.format(DateTimeFormatter.ISO_INSTANT)
    }
}


