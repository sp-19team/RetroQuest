package com.example.retroquest


import android.app.Activity
import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import pl.droidsonroids.gif.GifDrawable
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val questList = mutableListOf<questData>()
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

        val questIds = arrayOf(R.id.quest1, R.id.quest2, R.id.quest3, R.id.quest4, R.id.quest5)

        for (questId in questIds) {
            val detailQuest = findViewById<Button>(questId)
            detailQuest.setOnClickListener {
                val intent = Intent(this, DetailQuestActivity::class.java)
                startActivity(intent)
            }
        }


    }
}


