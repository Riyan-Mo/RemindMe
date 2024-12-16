package com.example.remindme.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.remindme.data.FakeDataStore
import com.example.remindme.data.Reminder
import com.example.remindme.navigation.Navigation
import com.example.remindme.ui.screen.HomeScreen
import com.example.remindme.ui.screen.LeftAlignedTopAppBar
import com.example.remindme.ui.screen.NewReminder

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RemindMeApp(
    modifier: Modifier = Modifier
) {
    val listOfReminders = FakeDataStore.fakeReminders
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

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        LeftAlignedTopAppBar(title = getCurrentRoute().title, navigateBack= {navigateBack()})
        NavHost(navController = navController, startDestination = Navigation.HOME.name) {
            composable(Navigation.ADD_NEW_REMINDER.name) {
                NewReminder(
                    onSubmit = { navigateBack() },
                    reminder = Reminder()
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