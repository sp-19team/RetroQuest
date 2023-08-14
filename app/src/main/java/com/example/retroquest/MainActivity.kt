package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var detailQuest = findViewById<Button>(R.id.questBtn)
        detailQuest.setOnClickListener {
            val intent = Intent(this,DetailQuestActivity::class.java)
            startActivity(intent)
        }

        var userlList = findViewById<Button>(R.id.userListBtn)
        userlList.setOnClickListener {
            val intent = Intent(this,UserListActivity::class.java)
            startActivity(intent)
        }
    }
}