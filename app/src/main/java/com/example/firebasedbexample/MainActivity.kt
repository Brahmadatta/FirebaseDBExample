package com.example.firebasedbexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var firebaseUser : FirebaseUser ?= null

    var mAuth : FirebaseAuth ?= null

    var mAuthListener : FirebaseAuth.AuthStateListener ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mAuth = FirebaseAuth.getInstance()

        mAuth!!.addAuthStateListener {
                firebaseAuth: FirebaseAuth ->
            firebaseUser = firebaseAuth.currentUser
            if (firebaseUser != null)
            {
                //Go to Dashboard
                startActivity(Intent(this, HomeScreenActivity::class.java))
                finish()
            }else{
                Toast.makeText(this,"Not Signed In", Toast.LENGTH_LONG).show()
            }
        }

//        mAuthListener = FirebaseAuth.AuthStateListener {
//                firebaseAuth: FirebaseAuth ->
//            firebaseUser = firebaseAuth.currentUser
//            if (firebaseUser != null)
//            {
//                //Go to Dashboard
//                startActivity(Intent(this, HomeScreenActivity::class.java))
//                finish()
//            }else{
//                Toast.makeText(this,"Not Signed In", Toast.LENGTH_LONG).show()
//            }
//        }



            login_admin.setOnClickListener {

                startActivity(Intent(this, AdminLoginActivity::class.java))
            }

            login_user_btn.setOnClickListener {

                startActivity(Intent(this, UserLoginActivity::class.java))
            }

            create_act_btn.setOnClickListener {
                startActivity(Intent(this, CreateAccountActivity::class.java))
            }


    }



}