package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class DetailQuestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_quest)

        var returnMain = findViewById<Button>(R.id.returnmain)
        returnMain.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        var questModify = findViewById<Button>(R.id.modify)
        questModify.setOnClickListener {
            val intent = Intent(this,/* 내용수정페이지 */::class.java)
            startActivity(intent)
        }

        val questcheck = findViewById<CheckBox>(R.id.questcheck)

        val questText = findViewById<TextView>(R.id.questtext)

    }
}