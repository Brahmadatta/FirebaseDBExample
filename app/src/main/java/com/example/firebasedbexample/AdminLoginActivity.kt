package com.example.firebasedbexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_admin_login.*

class AdminLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)


        loginAdminBtn.setOnClickListener {
            if (adminUserEdt.text.toString().equals("Brahma") && adminPassEdt.text.toString().equals("brahmadatta"))
            {

                startActivity(Intent(this,AdminUploadDataActivity::class.java))
            }
        }
    }
}