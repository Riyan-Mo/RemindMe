package com.example.remindme.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remindme.RemindMeApplication
import com.example.remindme.data.Reminder
import com.example.remindme.data.ReminderDatabaseRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class HomeScreenUiState(
    var reminders: List<Reminder> = emptyList()
)

class HomeScreenViewModel(
    private val reminderDatabaseRepository: ReminderDatabaseRepository
): ViewModel() {
    private val _uiState = reminderDatabaseRepository.getAllRemindersStream().map { HomeScreenUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = HomeScreenUiState()
        )
    val uiState = _uiState
    suspend fun addReminder(reminder: Reminder) {
        reminderDatabaseRepository.insertReminder(reminder)
    }

    suspend fun deleteItem(reminder: Reminder): Boolean {
        return reminderDatabaseRepository.deleteReminder(reminder)
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val remindMeApp = (this[APPLICATION_KEY] as RemindMeApplication)
                HomeScreenViewModel(remindMeApp.appContainer.reminderDatabaseRepository)
            }
        }
    }

}
