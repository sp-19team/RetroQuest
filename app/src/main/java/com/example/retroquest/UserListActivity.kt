package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val user1 = UserData("박세준", 29, "ISTP")
        val user2 = UserData("이인재", 27, "INFP")
        val user3 = UserData("박준범", 29, "ESTP")
        val user4 = UserData("이승훈", 25, "INFJ")


        var questButton = findViewById<Button>(R.id.questBtn)
        questButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        var noticeButton = findViewById<Button>(R.id.noticetBtn)
        noticeButton.setOnClickListener {
            val intent = Intent(this,ComunityActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val detailUsersBtn1 = findViewById<Button>(R.id.detailUsersBtn1)
        detailUsersBtn1.setOnClickListener {
            val intent = Intent(this, DetailUsersActivity::class.java)
            intent.putExtra("USERDATA", user1)
            intent.putExtra("BACKGROUND",R.drawable.profileback5)
            intent.putExtra("PROFILE",R.drawable.cuvi)
            startActivity(intent)
        }

        val detailUsersBtn2 = findViewById<Button>(R.id.detailUsersBtn2)
        detailUsersBtn2.setOnClickListener {
            val intent = Intent(this, DetailUsersActivity::class.java)
            intent.putExtra("USERDATA", user2)
            intent.putExtra("BACKGROUND",R.drawable.profileback4)
            intent.putExtra("PROFILE",R.drawable.sonic2)
            startActivity(intent)
        }
        val detailUsersBtn3 = findViewById<Button>(R.id.detailUsersBtn3)
        detailUsersBtn3.setOnClickListener {
            val intent = Intent(this, DetailUsersActivity::class.java)
            intent.putExtra("USERDATA", user3)
            intent.putExtra("BACKGROUND",R.drawable.profileback4)
            intent.putExtra("PROFILE",R.drawable.sonic1)
            startActivity(intent)
        }
        val detailUsersBtn4 = findViewById<Button>(R.id.detailUsersBtn4)
        detailUsersBtn4.setOnClickListener {
            val intent = Intent(this, DetailUsersActivity::class.java)
            intent.putExtra("USERDATA", user4)
            intent.putExtra("BACKGROUND",R.drawable.profileback3)
            intent.putExtra("PROFILE",R.drawable.mario)
            startActivity(intent)
        }

    }
}