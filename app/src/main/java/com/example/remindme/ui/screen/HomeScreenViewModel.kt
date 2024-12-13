package com.example.remindme.ui.screen

import androidx.lifecycle.ViewModel
import com.example.remindme.data.Reminder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomeScreenUiState(
    val reminders: List<Reminder> = emptyList()
)

class HomeScreenViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
}
