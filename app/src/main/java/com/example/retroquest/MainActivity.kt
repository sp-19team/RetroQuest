package com.example.retroquest


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val questList = mutableListOf<QuestData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var Quest = findViewById<Button>(R.id.questBtn)
        Quest.setOnClickListener {
            val intent = Intent(this,DetailQuestActivity::class.java)
            startActivity(intent)
        }

        var userlList = findViewById<Button>(R.id.userListBtn)
        userlList.setOnClickListener {
            val intent = Intent(this,UserListActivity::class.java)
            startActivity(intent)
        }

        val questIds = arrayOf(R.id.quest6, R.id.quest7, R.id.quest3, R.id.quest4, R.id.quest5)

        for (questId in questIds) {
            val detailQuest = findViewById<Button>(questId)
            detailQuest.setOnClickListener {
                val intent = Intent(this, DetailQuestActivity::class.java)
                startActivity(intent)
            }
        }


    }
}


