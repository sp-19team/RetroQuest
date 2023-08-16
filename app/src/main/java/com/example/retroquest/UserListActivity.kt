package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val user1 = UserData("박세준", 29, "ISTP")
        val user2 = UserData("킹왕쨩", 12, "ENTJ")

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
    }
}