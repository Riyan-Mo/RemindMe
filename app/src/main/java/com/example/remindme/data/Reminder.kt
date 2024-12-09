package com.example.remindme.data

import java.text.SimpleDateFormat
import java.util.Date

class Reminder (
    val title: String = "",
    private val due: Date = Date(),
    val type: Type = Type.ONE_TIME,
    val on: Boolean = true
) {
    private val timeHourFormat = SimpleDateFormat("hh:mm")

    fun getTime(): String {
        return timeHourFormat.format(due)
    }
}


