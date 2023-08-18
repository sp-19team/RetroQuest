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
    private val maxAlgorithmImages = 4
    private var currentImageIndex = 0
    private val maxAlgorithmImages1 = 4
    private var currentImageIndex1 = 0
    private val maxAlgorithmImages2 = 4
    private var currentImageIndex2 = 0

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


        nameTextView.text = userData?.name
        lvTextView.text = "Lv : ${userData?.lv}"
        mbtiTextView.text = "특성 : ${userData?.mbti}"

//


        val algoImageView1 = findViewById<ImageView>(R.id.picArea)
        updateAlgorithmImage(currentImageIndex, algoImageView1)

        val plusButton1 = findViewById<Button>(R.id.plusBtn)
        plusButton1.setOnClickListener {
            if (currentImageIndex < maxAlgorithmImages - 1) {
                currentImageIndex++
                updateAlgorithmImage(currentImageIndex, algoImageView1)
            }
        }

        val algoImageView2 = findViewById<ImageView>(R.id.picArea2)
        updateAlgorithmImage2(currentImageIndex1, algoImageView2)

        val plusButton2 = findViewById<Button>(R.id.plusBtn2)
        plusButton2.setOnClickListener {
            if (currentImageIndex1 < maxAlgorithmImages1 - 1) {
                currentImageIndex1++
                updateAlgorithmImage2(currentImageIndex1, algoImageView2)
            }
        }

        val algoImageView3 = findViewById<ImageView>(R.id.picArea3)
        updateAlgorithmImage3(currentImageIndex2, algoImageView3)

        val plusButton3 = findViewById<Button>(R.id.plusBtn3)
        plusButton3.setOnClickListener {
            if (currentImageIndex2 < maxAlgorithmImages2 - 1) {
                currentImageIndex2++
                updateAlgorithmImage3(currentImageIndex2, algoImageView3)
            }
        }



        val comu = findViewById<Button>(R.id.comuBtn)
        comu.setOnClickListener {
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
        }

    }
    private fun updateAlgorithmImage(index: Int, imageView: ImageView) {
        val imageResource = when (index) {
            0 -> R.drawable.pic1
            1 -> R.drawable.pic2
            2 -> R.drawable.pic3
            3 -> R.drawable.pic4
            else -> R.drawable.pic1
        }

        imageView.setImageResource(imageResource)
    }
    private fun updateAlgorithmImage2(index: Int, imageView: ImageView) {
        val imageResource2 = when (index) {
            0 -> R.drawable.pic1
            1 -> R.drawable.pic2
            2 -> R.drawable.pic3
            3 -> R.drawable.pic4
            else -> R.drawable.pic1
        }

        imageView.setImageResource(imageResource2)
    }
    private fun updateAlgorithmImage3(index: Int, imageView: ImageView) {
        val imageResource3 = when (index) {
            0 -> R.drawable.pic1
            1 -> R.drawable.pic2
            2 -> R.drawable.pic3
            3 -> R.drawable.pic4
            else -> R.drawable.pic1
        }

        imageView.setImageResource(imageResource3)
    }
}