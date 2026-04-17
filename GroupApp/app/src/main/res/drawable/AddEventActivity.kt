package com.example.groupapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.groupapp.storage.EventStorage

class AddEventActivity : AppCompatActivity() {

    private lateinit var eventTitle: EditText
    private lateinit var saveBtn: Button

    private var date: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_add_event
        )

        eventTitle =
            findViewById(R.id.eventTitle)

        saveBtn =
            findViewById(R.id.saveBtn)

        date =
            intent.getStringExtra("date") ?: ""

        saveBtn.setOnClickListener {

            val title =
                eventTitle.text.toString()

            if (title.isNotEmpty()) {

                EventStorage.saveEvent(
                    this,
                    date,
                    title
                )

                Toast.makeText(
                    this,
                    "Event Saved",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}