package com.example.remindme.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.remindme.navigation.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeftAlignedTopAppBar(
    title: String,
    navigateBack: ()->Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        navigationIcon = {
            if(title != Navigation.HOME.title){
                TextButton(onClick = {navigateBack()}) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Navigate Back")
                }
            }
        },
        title = {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium,
                )
        },
    )
}