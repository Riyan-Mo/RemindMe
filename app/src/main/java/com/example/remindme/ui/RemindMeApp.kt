package com.example.remindme.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.remindme.data.FakeDataStore
import com.example.remindme.data.Reminder
import com.example.remindme.ui.screen.LeftAlignedTopAppBar
import com.example.remindme.ui.screen.NewReminder

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RemindMeApp(
    modifier: Modifier = Modifier
) {
    val listOfReminders = FakeDataStore.fakeReminders
    Column{
        LeftAlignedTopAppBar(title = "Remind Me")
        NewReminder(onSubmit = {}, reminder = Reminder())
//        HomeScreen(
//            listOfReminders,
//            modifier = Modifier.padding(8.dp)
//        )
    }
}