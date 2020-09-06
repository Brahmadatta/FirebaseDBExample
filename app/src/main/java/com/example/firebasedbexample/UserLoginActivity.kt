package com.example.firebasedbexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_user_login_activity.*

class UserLoginActivity : AppCompatActivity() {

    var firebaseAuth : FirebaseAuth ?= null
    var mDatabase : DatabaseReference ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login_activity)


        firebaseAuth = FirebaseAuth.getInstance()

        login_user.setOnClickListener {

            var email = user_email.text.toString().trim()
            var pass = user_password.text.toString().trim()

            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass))
            {
                loginUser(email, pass)
            }
        }
    }

    fun loginUser(email : String, pass : String)
    {
        firebaseAuth!!.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener { task: Task<AuthResult> ->

                if (task.isSuccessful)
                {
                    var name = email.split("@")[0]

                    var loginIntent = Intent(this,HomeScreenActivity::class.java)
                    loginIntent.putExtra("name",name)
                    loginIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(loginIntent)
                    finish()
                }
            }
    }
}