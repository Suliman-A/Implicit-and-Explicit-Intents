package com.example.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CalendarContract.Events
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_2.*


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        button2.setOnClickListener { createAlarm("New Alarm", 7, 30) }

        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("me@somewhere.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "My subject")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(intent, "Email via..."))
            }

            startActivity(Intent.createChooser(intent, "Email via..."))
        }


        button3.setOnClickListener() {
            // Search for restaurants nearby
            val gmmIntentUri = Uri.parse("geo:0,0?q=restaurants")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        button4.setOnClickListener {
            val intent = Intent(Intent.ACTION_INSERT)

            intent.type = "vnd.android.cursor.item/event"
            //intent.putExtra(Events.TITLE, "Learn Android")
            intent.putExtra(Events.EVENT_LOCATION, "Home")
            intent.putExtra(Events.DESCRIPTION, "Implicit and Explicit Intents")

            val title = intent.getStringExtra("Learn Android")
            if (title != null) {
                startActivity(intent)
            } else {
                val toast = Toast.makeText(this, "The intent failed due to No event title provided", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        button5.setOnClickListener {
            val uri = Uri.parse("smsto:09060558023")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Here goes your message...")

            val number= intent.getStringExtra("smsto:09060558023")
            if (number != null) {
                startActivity(intent)
            } else {
                val toast = Toast.makeText(this, "The intent failed due to No Phone number provided", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}






