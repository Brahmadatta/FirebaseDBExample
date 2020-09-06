package com.example.firebasedbexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreenActivity : AppCompatActivity() {

    var firebaseUser : FirebaseUser ?= null

    var mAuth : FirebaseAuth ?= null

    var mAuthListener : FirebaseAuth.AuthStateListener ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        mAuth = FirebaseAuth.getInstance()


        if (intent.extras != null)
        {
            var username = intent!!.extras!!.get("name")
            nameofuser.text = username.toString()
        }
    }
}