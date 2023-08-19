package com.example.retroquest


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class DetailQuestActivity : AppCompatActivity() {

    // 체크박스와 버튼을 가리키는 변수
    private lateinit var questcheck1: CheckBox
    private lateinit var questcheck2: CheckBox
    private lateinit var questcheck3: CheckBox
    private lateinit var questcomplete: Button
    // 모든 퀘스트가 완료되었는지 나타내는 변수
    private var allQuestsCompleted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_quest)

        // '돌아가기' 버튼
        var returnMain = findViewById<Button>(R.id.returnmain)
        returnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 인텐트로 받아온 퀘스트 데이터 UI에 표시
        val questData = intent.getParcelableExtra<QuestData>("QUESTDATA")

        val questtitle = findViewById<TextView>(R.id.questtitle)
        val questdev = findViewById<TextView>(R.id.questdev)
        val questtype = findViewById<TextView>(R.id.questtype)

        questtitle.text = questData?.title
        questdev.text = questData?.des
        questtype.text = questData?.type

        // XML에서 정의한 체크박스와 완료버튼
        val questcheck1 = findViewById<CheckBox>(R.id.questcheck1)
        val questcheck2 = findViewById<CheckBox>(R.id.questcheck2)
        val questcheck3 = findViewById<CheckBox>(R.id.questcheck3)
        val completeButton: Button = findViewById(R.id.complete1)

        // 체크박스 상태변화 리스너
        questcheck1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // 체크 상태일 때 다른 이미지로 변경
                questcheck1.setBackgroundResource(R.drawable.people)
            } else {
                // 체크 해제 상태일 때 다시 원래 이미지로 변경
                questcheck1.setBackgroundResource(R.drawable.quest)
            }
        }

        questcheck2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                questcheck2.setBackgroundResource(R.drawable.people)
            } else {
                questcheck2.setBackgroundResource(R.drawable.quest)
            }
        }

        questcheck3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                questcheck3.setBackgroundResource(R.drawable.people)
            } else {
                questcheck3.setBackgroundResource(R.drawable.quest)
            }
        }


        // 퀘스트 완료 버튼
        completeButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // XML에 있는 모든 CheckBox를 찾아서 체크
                checkAllCheckBoxes()

                // MainActivity로 "퀘스트완료" 정보를 전달
                val intent = Intent(this@DetailQuestActivity, MainActivity::class.java)
                intent.putExtra("quest_status", "퀘스트완료")
                startActivity(intent)
            }
        })
    }

    // 체크박스 배경 이미지 업데이트 함수
    // private fun updateCheckboxDrawable(checkbox: CheckBox, isChecked: Boolean) {

    //   val drawableResId = if (isChecked) R.drawable.people else R.drawable.quest

    //    checkbox.buttonDrawable = resources.getDrawable(drawableResId, null)
    //}

    // 모든 퀘스트가 완료되었는지 확인하는 함수
    private fun checkAllCheckBoxes() {
        // XML에서 모든 CheckBox ID를 가져와서 체크
        val checkBoxIds = arrayOf(
            R.id.questcheck1,R.id.questcheck2,R.id.questcheck3

        )

        for (checkBoxId in checkBoxIds) {
            val checkBox = findViewById<CheckBox>(checkBoxId)
            checkBox.isChecked = true
        }
    }

}


