package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)


        val detailUsersBtn = findViewById<Button>(R.id.detailUsersBtn)
        detailUsersBtn.setOnClickListener {
            val intent = Intent(this,DetailUsersActivity::class.java)
            startActivity(intent)
        }
    }
}