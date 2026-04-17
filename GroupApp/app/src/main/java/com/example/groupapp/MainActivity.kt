package com.example.groupapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.groupapp.storage.EventStorage


class MainActivity : extracted()() {

    private lateinit var calendarView: CalendarView
    private lateinit var addEventBtn: Button
    private lateinit var eventListView: ListView

    private var selectedDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendarView =
            findViewById(R.id.calendarView)

        addEventBtn =
            findViewById(R.id.addEventBtn)

        eventListView =
            findViewById(R.id.eventListView)

        calendarView.setOnDateChangeListener {

                _, year, month, day ->

            selectedDate =
                "$day/${month+1}/$year"

            loadEvents()
        }

        addEventBtn.setOnClickListener {

            val intent =
                Intent(
                    this,
                    AddEventActivity::class.Kotlin
                )

            intent.putExtra(
                "date",
                selectedDate
            )

            startActivity(intent)
        }
    }

    override fun onResume() {

        super.onResume()

        loadEvents()
    }

    private fun loadEvents() {

        val events =
            EventStorage.getEvents(
                this,
                selectedDate
            )

        val adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                events
            )

        eventListView.adapter = adapter
    }
}

private fun extracted() {
    AppCompatActivity
}