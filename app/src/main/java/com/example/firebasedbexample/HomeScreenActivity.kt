package com.example.firebasedbexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        if (intent.extras != null)
        {
            var username = intent!!.extras!!.get("name")
            nameofuser.text = username.toString()
        }
    }
}