package com.example.remindme.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remindme.data.Reminder
import com.example.remindme.data.Type
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewReminder(
    onReminderChange: (reminder: Reminder) -> Unit,
    reminder: Reminder,
    modifier: Modifier =  Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = reminder.title,
            onValueChange = { onReminderChange(reminder) },
            label = { Text(text = "Title")},
            modifier = modifier
        )

        TimePicker(
            state = TimePickerState(
                initialHour = Date().hours,
                initialMinute = Date().minutes,
                is24Hour = false),
        )
    }
}

@Preview
@Composable
fun NewReminderPreview() {
    NewReminder(
        onReminderChange = {},
        reminder = Reminder()
    )
}