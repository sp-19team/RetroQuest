package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import pl.droidsonroids.gif.GifDrawable
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)




        val titleEditText = findViewById<EditText>(R.id.titleEditText)
        val authorEditText = findViewById<EditText>(R.id.authorEditText)
        val contentEditText = findViewById<EditText>(R.id.contentEditText)



        val submitBtn = findViewById<Button>(R.id.submitButton)
        submitBtn.setOnClickListener {
            val title = titleEditText.text.toString()
            val author = authorEditText.text.toString()
            val content = contentEditText.text.toString()

            val curentDate = SimpleDateFormat("YYYY-MM-DD", Locale.getDefault()).format(Date())
            if (title.isEmpty() || author.isEmpty() || content.isEmpty()) {
                // 필수 정보를 입력하지 않았을 경우 Toast 메시지 출력
                Toast.makeText(this, "모든 정보를 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val cuviImg = findViewById<RadioButton>(R.id.cuviBtn)
            val marioImg = findViewById<RadioButton>(R.id.marioBtn)
            var sonicImg = findViewById<RadioButton>(R.id.sonicBtn)
            val sonicImg2 = findViewById<RadioButton>(R.id.sonic2Btn)

            var imgInt = 0

            if (cuviImg.isChecked) {
                imgInt = 1
            } else if (marioImg.isChecked) {
                imgInt = 2
            } else if (sonicImg.isChecked) {
                imgInt = 3
            } else if (sonicImg2.isChecked) {
                imgInt = 4
            }else{
                Toast.makeText(this,"이미지 선택HA라구여",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }




            val intent  = Intent(this,ComunityActivity::class.java)
            intent.putExtra("TITLE",title)
            intent.putExtra("AUTHOR",author)
            intent.putExtra("CONTENT",content)
            intent.putExtra("DATE",curentDate)
            intent.putExtra("IMAGE",imgInt)

            setResult(RESULT_OK,intent)
            finish()

            val cancle = findViewById<Button>(R.id.cancelButton)
            cancle.setOnClickListener {
                finish()
            }

        }

    }
}