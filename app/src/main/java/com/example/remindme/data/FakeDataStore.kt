package com.example.remindme.data

import java.util.Date

class FakeDataStore {

    companion object {
        private val reminder1 = Reminder(
            title ="Read Book",
            due = Date(),
            type = Type.ONE_TIME,
            on = true
        )
        private val reminder2 = Reminder(
            title ="Wake Up",
            due = Date(),
            type = Type.RECURRING,
            on = true
        )
        val fakeReminders = mutableListOf(reminder1, reminder2)
    }
}