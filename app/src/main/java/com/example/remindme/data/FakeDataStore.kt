package com.example.remindme.data

import java.time.LocalTime
import java.time.format.DateTimeFormatter

class FakeDataStore {

    companion object {
        private val reminder1 = Reminder(
            title ="Read Book",
            due = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")),
            type = Type.ONE_TIME,
            on = true
        )
        private val reminder2 = Reminder(
            title ="Wake Up",
            due = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")),
            type = Type.RECURRING,
            on = true
        )
        val fakeReminders = mutableListOf(reminder1, reminder2)
    }
}