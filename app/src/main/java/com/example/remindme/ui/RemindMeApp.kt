package com.example.remindme.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.remindme.data.FakeDataStore
import com.example.remindme.ui.screen.HomeScreen
import com.example.remindme.ui.screen.LeftAlignedTopAppBar

@Composable
fun RemindMeApp(
    modifier: Modifier = Modifier
) {
    val listOfReminders = FakeDataStore.fakeReminders
    Column{
        LeftAlignedTopAppBar(title = "Remind Me")
        HomeScreen(
            listOfReminders,
            modifier = Modifier.padding(8.dp)
        )
    }
}