package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()



        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            Intent(this, LoginActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }, 3000) // 3초 후(3000) 스플래시 화면을 닫습니다
    }
}