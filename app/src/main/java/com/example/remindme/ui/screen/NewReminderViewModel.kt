package com.example.remindme.ui.screen

import androidx.lifecycle.ViewModel
import com.example.remindme.data.Reminder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class NewReminderUiState(
    var reminder: Reminder = Reminder()
)

class NewReminderViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(NewReminderUiState())
    val uiState: StateFlow<NewReminderUiState> = _uiState.asStateFlow()



}