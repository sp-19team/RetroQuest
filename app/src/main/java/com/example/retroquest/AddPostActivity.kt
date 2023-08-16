package com.example.retroquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

            val curentDate = SimpleDateFormat("YYYY=MM-DD", Locale.getDefault()).format(Date())


            val intent  = Intent(this,ComunityActivity::class.java)
            intent.putExtra("TITLE",title)
            intent.putExtra("AUTHOR",author)
            intent.putExtra("CONTENT",content)
            intent.putExtra("DATE",curentDate)

            setResult(RESULT_OK,intent)
            finish()

        }

    }
}