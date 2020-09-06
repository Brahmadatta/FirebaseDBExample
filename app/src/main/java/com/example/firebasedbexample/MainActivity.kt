package com.example.firebasedbexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mDataBase : DatabaseReference ?= null
    var firebaseUser : FirebaseUser ?= null
    var mAuth : FirebaseAuth ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mAuth = FirebaseAuth.getInstance()


        login_admin.setOnClickListener {

            startActivity(Intent(this,AdminLoginActivity::class.java))
        }

        login_user_btn.setOnClickListener {

            startActivity(Intent(this,UserLoginActivity::class.java))
        }

        create_act_btn.setOnClickListener {
            startActivity(Intent(this,CreateAccountActivity::class.java))
        }


    }


}