package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val loginText = findViewById<EditText>(R.id.loginEditTextId)
        val pwText = findViewById<EditText>(R.id.loginEditTextPw)
        val mainImg = findViewById<ImageView>(R.id.profileImages)


        //선택 이미지 보여주기


        //signUp에서 정보 가져오기
        val activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val user_id = it.data?.getStringExtra("id") ?: ""
                    val user_pw = it.data?.getStringExtra("pw") ?: ""
                    val user_img = it.data?.getStringExtra("img") ?: "0"


                    mainImg.setImageResource(when(user_img.toInt()){
                        1->R.drawable.cuvi
                        2->R.drawable.mario
                        3->R.drawable.sonic1
                        4->R.drawable.sonic2
                        else -> R.drawable.cuvi
                    })

                    loginText.setText(user_id)
                    pwText.setText(user_pw)

                }
            }

        // 시작 버튼 눌렸을 때 main화면 실행
        val login = findViewById<Button>(R.id.loginBtn)
        login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 회원가입 버튼 눌렸을 때 signUp화면 실행

        val signUp = findViewById<Button>(R.id.signUpBtn)
        signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activityResultLauncher.launch(intent)

        }


    }


}



