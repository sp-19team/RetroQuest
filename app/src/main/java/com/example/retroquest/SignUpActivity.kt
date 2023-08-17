package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val cuviImg = findViewById<RadioButton>(R.id.cuvi)
        val marioImg = findViewById<RadioButton>(R.id.mario)
        var sonicImg = findViewById<RadioButton>(R.id.sonic)
        val sonicImg2 = findViewById<RadioButton>(R.id.sonic2)


        val signUpBtn = findViewById<Button>(R.id.inSignUpBtn)

        var imgInt = 0


        cuviImg.setOnClickListener {
            imgInt = 1

        }

        marioImg.setOnClickListener {
            imgInt = 2
        }

        sonicImg.setOnClickListener {
            imgInt = 3


        }
        sonicImg2.setOnClickListener {
            imgInt = 4
        }


        //회원가입 버튼 눌렸을 때
        signUpBtn.setOnClickListener {
            val signId = findViewById<EditText>(R.id.signUpEditTextId)
            val signIdText = signId.text.toString()
            val signPw = findViewById<EditText>(R.id.signUpEditTextPw)
            val signPwText = signPw.text.toString()









            if (signIdText.isEmpty() || signPwText.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra("id", signIdText)
                    putExtra("pw", signPwText)
                    putExtra("img", imgInt.toString())


                }
                setResult(RESULT_OK, intent)
                if (!isFinishing) finish()


            }


        }

    }


    //이미지


}











