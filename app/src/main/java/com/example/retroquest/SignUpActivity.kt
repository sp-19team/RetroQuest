package com. example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val cuviImg = findViewById<RadioButton>(R.id.cuvi)
        val marioImg = findViewById<RadioButton>(R.id.mario)
        var sonicImg = findViewById<RadioButton>(R.id.sonic)
        val sonicImg2 = findViewById<RadioButton>(R.id.sonic2)
        val signId = findViewById<EditText>(R.id.signUpEditTextId)
        val signPw = findViewById<EditText>(R.id.signUpEditTextPw)
        val idText = findViewById<TextView>(R.id.idText)
        val pwText = findViewById<TextView>(R.id.pwText)



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


        // 아이디 edit textwatcher
        signId.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val length: Int = s?.length ?: 0

                //커서 따라가기
                idText.requestFocus()

                //아이디의 길이에 따른 에러메세지
                when(length){
                    0 -> idText.text="아이디를 입력해주세요"
                    in 1..5 -> idText.text = "아이디가 너무 짧아요"
                    in 6..25 -> idText. text = "사용 가능한 아이디 입니다."
                    else -> idText.text = "아이디가 너무 길어요"
                }
                }



        })

        //비밀번호 edittet textwatcher
        signPw.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val length: Int = s?.length ?: 0
                //비밀번호 길이에 따른 메세지
                when(length){
                    0 -> pwText.text="비밀번호를 입력해주세요"
                    in 1..5 -> pwText.text = "비밀번호가 너무 짧아요"
                    //길이가 적당할 때 숫자가 포함되어있는지 확인
                    in 6..25 -> if(s.toString().filter { it.isDigit() }.firstOrNull()==null){
                        pwText.text = "하나 이상의 숫자를 포함해주세요"} else{pwText.text = "사용 가능한 비밀번호 입니다."}
                    else -> pwText.text = "비밀번호가 너무 길어요"
                }

                }



        })
        //회원가입 버튼 눌렸을 때
        signUpBtn.setOnClickListener {
            val signIdText = signId.text.toString()
            val signPwText = signPw.text.toString()
            val correctId = idText.text
            val correctPw = pwText.text

            //아이디또는 비밀번호가 비었을때
            if (signIdText.isEmpty() || signPwText.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            //textwatcher에의한 textview의 결과
            }else if (correctId != "사용 가능한 아이디 입니다." || correctPw != "사용 가능한 비밀번호 입니다."){
                Toast.makeText(this, "아이디, 비밀번호가 사용 가능한지 확인해주세요",Toast.LENGTH_LONG ).show()

            }
            else {

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










}











