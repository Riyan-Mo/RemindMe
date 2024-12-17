package com.example.remindme.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.remindme.data.Reminder
import com.example.remindme.ui.screen.components.ReminderItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    reminders: MutableList<Reminder>,
    modifier: Modifier = Modifier,
    onFloatingButtonClicked: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onFloatingButtonClicked,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add")
            }
        },
    ) {
        if(reminders.isEmpty()){
                Text(
                    text = "No Reminders For Now!",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(top = 32.dp)
                )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(reminders) {
                    ReminderItem(it, {}, modifier = modifier)
                }
            }
        }
    }
}