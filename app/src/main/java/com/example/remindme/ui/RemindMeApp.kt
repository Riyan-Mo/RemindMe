package com.example.remindme.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.remindme.data.Reminder
import com.example.remindme.navigation.Navigation
import com.example.remindme.ui.screen.HomeScreen
import com.example.remindme.ui.screen.HomeScreenViewModel
import com.example.remindme.ui.screen.LeftAlignedTopAppBar
import com.example.remindme.ui.screen.NewReminder
import kotlinx.coroutines.launch

@Composable
fun RemindMeApp(
    modifier: Modifier = Modifier,
    homeScreenViewModel: HomeScreenViewModel = viewModel(factory = HomeScreenViewModel.factory)
) {
    val homeScreenUiState = homeScreenViewModel.uiState
    val listOfReminders = homeScreenUiState.reminders

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    fun navigateBack() {
        navController.popBackStack()
    }

    fun navigateToAddReminder() {
        navController.navigate(Navigation.ADD_NEW_REMINDER.name)
    }

    fun getCurrentRoute(): Navigation {
        return Navigation.valueOf(navBackStackEntry?.destination?.route?:"HOME")
    }

    suspend fun addNewReminder(reminder: Reminder) {
        homeScreenViewModel.addReminder(reminder)
        navigateBack()
    }

    val coroutineScope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        LeftAlignedTopAppBar(title = getCurrentRoute().title, navigateBack= {navigateBack()})
        NavHost(navController = navController, startDestination = Navigation.HOME.name) {
            composable(Navigation.ADD_NEW_REMINDER.name) {
                NewReminder(
                    onSubmit = { coroutineScope.launch {
                        addNewReminder(it)
                    } }
                )
            }
            composable(Navigation.HOME.name) {
                HomeScreen(
                    listOfReminders,
                    onFloatingButtonClicked = {navigateToAddReminder()},
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}