package com.example.remindme.ui.screen.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remindme.data.Reminder
import com.example.remindme.data.Type
import kotlinx.coroutines.Job

@Composable
fun ReminderItem(
    reminder: Reminder,
    onCheckChanged: () -> Unit,
    onDeleteClicked: (reminder: Reminder) -> Job,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current

    fun handleDelete(title: String, context: Context) {
        onDeleteClicked(reminder)
        Toast.makeText(context, "$title was deleted", Toast.LENGTH_SHORT).show()
    }

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(12.dp)
        ) {
            val type = if (reminder.type == Type.RECURRING) "Daily" else "Once"
            Text(
                text = type,
                style = MaterialTheme.typography.titleLarge
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = reminder.title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = reminder.on,
                    onCheckedChange = { onCheckChanged() },
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = reminder.due,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                Button(onClick = {
                    handleDelete(reminder.title, context)
                }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Reminder")
                }
            }
        }
    }
}

@Preview
@Composable
fun ReminderItemPreview() {
    val reminder = Reminder()
    ReminderItem(reminder = reminder, onCheckChanged = {}, onDeleteClicked = { Job() })
}