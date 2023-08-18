package com.example.retroquest


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class DetailQuestActivity : AppCompatActivity() {

    private val questList = mutableListOf<QuestData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_quest)

        var returnMain = findViewById<Button>(R.id.returnmain)
        returnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val questtitle1 = findViewById<TextView>(R.id.questtitle1)
        val questdes1 = findViewById<TextView>(R.id.questdes1)
        val questtype1 = findViewById<TextView>(R.id.questtype1)

        val questData = intent.getParcelableExtra<QuestData>("QUESTDATA")

        questtitle1.text = questData?.title
        questdes1.text = questData?.des
        questtype1.text = questData?.type

        // 체크박스와 보물상자
        val questcheck1 = findViewById<CheckBox>(R.id.questcheck1)
        val questcheck2 = findViewById<CheckBox>(R.id.questcheck2)
        val questcheck3 = findViewById<CheckBox>(R.id.questcheck3)
        val reward = findViewById<Button>(R.id.reward)

        questcheck1.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    questcheck1.buttonDrawable = resources.getDrawable(R.drawable.people, null)
                } else {
                    questcheck1.buttonDrawable = resources.getDrawable(R.drawable.quest, null)
                }
        }

        questcheck2.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    questcheck2.buttonDrawable = resources.getDrawable(R.drawable.people, null)
                } else {
                    questcheck2.buttonDrawable = resources.getDrawable(R.drawable.quest, null)
                }
        }

        questcheck3.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    questcheck3.buttonDrawable = resources.getDrawable(R.drawable.people, null)
                } else {
                    questcheck3.buttonDrawable = resources.getDrawable(R.drawable.quest, null)
                }
        }

        reward.setOnClickListener {
                        questcheck1.isChecked = true
                        questcheck2.isChecked = true
                        questcheck3.isChecked = true
        }
    }
}


