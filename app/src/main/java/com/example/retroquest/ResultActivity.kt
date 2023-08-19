package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 인텐트에서 데이터를 받아옴
        val rewardData = intent.getSerializableExtra("RESULTDATA") as? ResultData

        // 데이터를 UI에 설정
        val reward1 = findViewById<TextView>(R.id.textView7)
        val reward2 = findViewById<TextView>(R.id.textView10)
        val reward3 = findViewById<TextView>(R.id.textView14)

        rewardData?.let {
            reward1.text = it.message1
            reward2.text = it.message2
            reward3.text = it.message3
        }

        val receive = findViewById<Button>(R.id.button)
        receive.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "축하합니다. 한걸음 더 나아가셨어요!", Toast.LENGTH_SHORT).show()
        }
    }
}
