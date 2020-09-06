package com.example.firebasedbexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity() {

    var firebaseAuth : FirebaseAuth ?= null
    var firebaseUser : FirebaseUser ?= null
    var mDatabase : DatabaseReference ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)


        firebaseAuth = FirebaseAuth.getInstance()


        createAccountButton.setOnClickListener {

            var email = enterEmailEt.text.toString().trim()
            var pass = enterPasswordEt.text.toString().trim()
            var name = enterNameEt.text.toString().trim()

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email)
                && !TextUtils.isEmpty(pass))
            {

                createAccount(email,pass,name)
            }
        }


    }

    fun createAccount(email : String,password : String,displayName : String)
    {
        firebaseAuth!!.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                task : Task<AuthResult> ->

                if (task.isSuccessful)
                {
                    var currentUser = firebaseAuth!!.currentUser
                    var userid = firebaseAuth!!.uid

                    mDatabase = FirebaseDatabase.getInstance().reference.child("UserData")
                        .child(userid.toString())

                    var userdataObj = HashMap<String,String>()
                    userdataObj.put("userid",userid.toString())
                    userdataObj.put("uid",mDatabase!!.key.toString())
                    userdataObj.put("userimage","default")


                    mDatabase!!.setValue(userdataObj).addOnCompleteListener {
                        task : Task<Void> ->
                        if (task.isSuccessful)
                        {

                            var intent = Intent(this,HomeScreenActivity::class.java)
                            intent.putExtra("name",displayName)
                            startActivity(intent)

                        }else{

                        }
                    }
                }

            }
    }
}