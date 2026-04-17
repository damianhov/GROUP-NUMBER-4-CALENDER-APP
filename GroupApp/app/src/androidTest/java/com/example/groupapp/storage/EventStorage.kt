package com.example.groupapp.storage

import android.content.Context

object EventStorage {

    private const val PREF_NAME = "CalendarEvents"

    fun saveEvent(
        context: Context,
        date: String,
        title: String
    ) {

        val prefs =
            context.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
            )

        val oldEvents =
            prefs.getString(date, "") ?: ""

        val newEvents =
            oldEvents + title + ","

        prefs.edit()
            .putString(date, newEvents)
            .apply()
    }

    fun getEvents(
        context: Context,
        date: String
    ): List<String> {

        val prefs =
            context.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
            )

        val data =
            prefs.getString(date, "") ?: ""

        if (data.isEmpty())
            return listOf()

        return data.split(",")
            .filter { it.isNotEmpty() }
    }
}