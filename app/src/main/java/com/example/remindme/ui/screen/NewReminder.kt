package com.example.remindme.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remindme.data.Reminder
import com.example.remindme.data.Type
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewReminder(
    onSubmit: (reminder: Reminder)->Unit,
    reminder: Reminder,
    modifier: Modifier =  Modifier
) {
    val localTime = LocalTime.now()
    val title by rememberSaveable {
        mutableStateOf("")
    }
    val timePickerState = rememberTimePickerState (
        initialHour = localTime.hour,
        initialMinute = localTime.minute,
        is24Hour = true
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = reminder.title,
            onValueChange = { },
            label = { Text(text = "Title")},
            modifier = modifier
        )

        TimeInput(
            state = timePickerState,
            modifier = modifier
        )
        Button(
            onClick = { onSubmit(
                Reminder(
                    title = title,
                    on = true,
                    type = Type.ONE_TIME,
                    due = LocalTime.of(timePickerState.hour, timePickerState.minute)
                )
            ) },
            modifier = modifier
        ) {
            Text(
                text = "Add Reminder",
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun NewReminderPreview() {
    NewReminder(
        onSubmit = {},
        reminder = Reminder()
    )
}