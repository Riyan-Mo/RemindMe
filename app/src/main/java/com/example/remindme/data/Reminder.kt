package com.example.remindme.data

import java.time.LocalTime

data class Reminder (
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