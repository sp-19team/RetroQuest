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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        private val questList = mutableListOf<questData>()




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


