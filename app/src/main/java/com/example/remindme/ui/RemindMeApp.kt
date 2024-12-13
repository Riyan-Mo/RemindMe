package com.example.remindme.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.remindme.data.FakeDataStore
import com.example.remindme.data.Reminder
import com.example.remindme.ui.screen.HomeScreen
import com.example.remindme.ui.screen.LeftAlignedTopAppBar
import com.example.remindme.ui.screen.NewReminder

@Composable
fun RemindMeApp(
    modifier: Modifier = Modifier
) {
    val listOfReminders = FakeDataStore.fakeReminders
    Column{
        LeftAlignedTopAppBar(title = "Remind Me")
        NewReminder(onReminderChange = {}, reminder = Reminder())
//        HomeScreen(
//            listOfReminders,
//            modifier = Modifier.padding(8.dp)
//        )
    }
}