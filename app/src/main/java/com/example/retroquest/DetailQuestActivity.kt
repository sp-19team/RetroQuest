package com.example.retroquest


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val questtitle1 = findViewById<TextView>(R.id.questtitle1)
        val questdes1 = findViewById<TextView>(R.id.questdes1)
        val questtype1 = findViewById<TextView>(R.id.questtype1)

        val questData = intent.getParcelableExtra<QuestData>("QUESTDATA")

        questtitle1.text = questData?.title
        questdes1.text = questData?.des
        questtype1.text = questData?.type

        // XML에서 정의한 체크박스와 완료버튼
        val questcheck1 = findViewById<CheckBox>(R.id.questcheck1)
        val questcheck2 = findViewById<CheckBox>(R.id.questcheck2)
        val questcheck3 = findViewById<CheckBox>(R.id.questcheck3)
        val complete1 = findViewById<Button>(R.id.complete1)

        // 체크박스 상태변화 리스너
        questcheck1.setOnCheckedChangeListener { _, isChecked ->
            updateCheckboxDrawable(questcheck1, isChecked)
            checkAllQuestsCompleted()
        }

        questcheck2.setOnCheckedChangeListener { _, isChecked ->
            updateCheckboxDrawable(questcheck2, isChecked)
            checkAllQuestsCompleted()
        }

        questcheck3.setOnCheckedChangeListener { _, isChecked ->
            updateCheckboxDrawable(questcheck3, isChecked)
            checkAllQuestsCompleted()
        }


        // 퀘스트 완료 버튼
        complete1.setOnClickListener {
            if (allQuestsCompleted) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("QUEST_COMPLETED", true)
                startActivity(intent)
            }
        }


    }

    // 체크박스 배경 이미지 업데이트 함수
    private fun updateCheckboxDrawable(checkbox: CheckBox, isChecked: Boolean) {

        val drawableResId = if (isChecked) R.drawable.people else R.drawable.quest

        checkbox.buttonDrawable = resources.getDrawable(drawableResId, null)
    }

    // 모든 퀘스트가 완료되었는지 확인하는 함수
    private fun checkAllQuestsCompleted() {

        var questcomplete =
            questcheck1.isChecked && questcheck2.isChecked && questcheck3.isChecked
    }

}


