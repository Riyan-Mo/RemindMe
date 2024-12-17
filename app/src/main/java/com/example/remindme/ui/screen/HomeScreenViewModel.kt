package com.example.remindme.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remindme.data.Reminder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class HomeScreenUiState(
    var reminders: MutableList<Reminder> = mutableListOf()
)

class HomeScreenViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    fun addReminder(reminder: Reminder) {
        _uiState.update {
            val copyOfReminders = it.reminders
            copyOfReminders.add(reminder)
            Log.e("New Reminder", uiState.value.reminders.toString())
            it.copy(reminders = copyOfReminders)
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                HomeScreenViewModel()
            }
        }
    }

}
