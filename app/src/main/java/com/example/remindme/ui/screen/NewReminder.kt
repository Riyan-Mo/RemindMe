package com.example.remindme.ui.screen

import android.os.Build
import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remindme.data.Reminder
import com.example.remindme.data.Type
import java.time.LocalDateTime

fun validateInput(title: String): Boolean {
    return title.isNotBlank()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewReminder(
    onSubmit: (reminder: Reminder) -> Unit,
    reminder: Reminder,
    modifier: Modifier = Modifier
) {
    val localTime = LocalDateTime.now()
    var title by rememberSaveable {
        mutableStateOf(reminder.title)
    }
    val timePickerState = rememberTimePickerState (
        initialHour = localTime.hour,
        initialMinute = localTime.minute,
        is24Hour = true
    )
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(48.dp),
        modifier = modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Title")},
            modifier = modifier
        )
        TimeInput(
            state = timePickerState,
            modifier = modifier
        )
        Button(
            onClick = {
                if(validateInput(title = title)){
                    Log.e("New Reminder", localTime.toString())
                    onSubmit(
                        Reminder(
                            title = title,
                            on = true,
                            type = Type.ONE_TIME,
                            due = "${timePickerState.hour}:${timePickerState.minute}"
                        )
                    )
                } else {
                  Toast.makeText(context, "Title is Empty", Toast.LENGTH_SHORT).show()
                } },
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