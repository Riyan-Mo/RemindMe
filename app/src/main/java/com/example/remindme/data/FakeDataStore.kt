package com.example.remindme.data

import java.time.LocalTime

class FakeDataStore {

    companion object {
        private val reminder1 = Reminder(
            title ="Read Book",
            due = LocalTime.now(),
            type = Type.ONE_TIME,
            on = true
        )
        private val reminder2 = Reminder(
            title ="Wake Up",
            due = LocalTime.now(),
            type = Type.RECURRING,
            on = true
        )
        val fakeReminders = mutableListOf(reminder1, reminder2)
    }
}