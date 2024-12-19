package com.example.remindme.alarm

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.example.remindme.data.Reminder
import java.time.ZoneOffset

class AlarmRepository(
    private val context: Context
) {
    private val alarmManager: AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    @SuppressLint("MissingPermission")
    fun setAlarm(reminder: Reminder) {
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra("EXTRA_MESSAGE", reminder.title)
        }
        alarmManager.setExact(AlarmManager.RTC,
            reminder.dueToLocale().toEpochSecond(ZoneOffset.systemDefault() as ZoneOffset?),
            PendingIntent.getBroadcast(
                context,
                reminder.title.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                )
            )
    }

    fun removeAlarm(reminder: Reminder) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                reminder.title.hashCode(),
                Intent(),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }

}