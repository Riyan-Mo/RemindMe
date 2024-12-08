package com.example.remindme.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RemindMeApp(
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "Remind Me",
            style = MaterialTheme.typography.displayLarge
        )
    }
}