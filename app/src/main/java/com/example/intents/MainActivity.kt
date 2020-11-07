package com.example.intents

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     logIn_button.setOnClickListener{
      if (userName_editText.text.toString().equals("Suliman") && passwors_editText.text.toString().equals("123321")){

          Toast.makeText(this, "Redirecting...", Toast.LENGTH_SHORT).show();
          val intent = Intent(this@MainActivity, Activity2::class.java) // redirecting to LoginActivity.
          startActivity(intent)

      }else{
          Toast.makeText(this, "logIn Failed", Toast.LENGTH_SHORT).show();
      }

     }
    }
}