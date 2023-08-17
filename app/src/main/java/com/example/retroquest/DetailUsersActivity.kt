package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import pl.droidsonroids.gif.GifDrawable

class DetailUsersActivity : AppCompatActivity() {
    private var algorithmLevel = 0
    private var kotlinLevel = 0
    private var gitgubLevel = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail_users)


        val userData = intent.getSerializableExtra("USERDATA") as? UserData

        val backGround = intent.getIntExtra("BACKGROUND", R.drawable.ic_launcher_background)
        val backId = findViewById<ImageView>(R.id.backgroundImage)
        // GIF 이미지 리소스를 GifDrawable로 로드하고 배경으로 설정
        val gifDrawable = GifDrawable(
            resources,
            backGround
        )
        backId.setImageDrawable(gifDrawable)

        // 애니메이션 시작
        gifDrawable.start()

        val profile = intent.getIntExtra("PROFILE", R.drawable.ic_launcher_background)
        val profileId = findViewById<ImageView>(R.id.profileImageArea)
        profileId.setImageResource(profile)


        val nameTextView = findViewById<Button>(R.id.nameArea)
        val lvTextView = findViewById<TextView>(R.id.lvTextViewArea)
        val mbtiTextView = findViewById<TextView>(R.id.mbtiTextViewArea)
        val algoTextView = findViewById<TextView>(R.id.algoTextViewArea)
        val kotlinTextView = findViewById<TextView>(R.id.kotlinTextViewArea)
        val githubTextView = findViewById<TextView>(R.id.githubTextViewArea)

        nameTextView.text = userData?.name
        lvTextView.text = "Lv : ${userData?.lv}"
        mbtiTextView.text = "특성 : ${userData?.mbti}"




        val plusButton = findViewById<Button>(R.id.plusBtn)
        plusButton.setOnClickListener {
            if (algorithmLevel < 100) {
                algorithmLevel++
                algoTextView.text = "algorithm : $algorithmLevel/100"
            }
        }

            val plusButton2 =findViewById<Button>(R.id.plusBtn2)
            plusButton2.setOnClickListener {
                if (kotlinLevel<100){
                    kotlinLevel++
                    kotlinTextView.text = " kotiln : ${kotlinLevel}/100"
                }
            }
        val plusButton3 =findViewById<Button>(R.id.plusBtn3)
        plusButton3.setOnClickListener {
            if (gitgubLevel<100){
                gitgubLevel++
                githubTextView.text = "github : ${gitgubLevel}/100"
            }
        }

        val comu = findViewById<Button>(R.id.comuBtn)
        comu.setOnClickListener {
            val intent = Intent(this,ComunityActivity::class.java)
            startActivity(intent)
        }

    }
}