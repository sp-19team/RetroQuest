package com.example.retroquest


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val questList = mutableListOf<QuestData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var community = findViewById<Button>(R.id.questBtn)
        community.setOnClickListener {
            val intent = Intent(this, ComunityActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        var userlList = findViewById<Button>(R.id.userListBtn)
        userlList.setOnClickListener {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val quest1 = QuestData("알고리즘 테스트", "lv.1 알고리즘 문제를 3회 풉니다.", "일일 퀘스트")
        val quest2 = QuestData("팀 프로젝트", "팀 프로젝트를 완성합니다.", "주간 퀘스트")
        val quest3 = QuestData("TIL 작성", "TIL을 작성합니다.", "일일 퀘스트")
        val quest4 = QuestData("WIL 작성", "WIL을 작성합니다.", "주간 퀘스트")
        val quest5 = QuestData("주간 KPT 작성하기", "KPT를 작성합니다.", "주간 퀘스트")


        val isQuestCompleted = intent.getBooleanExtra("QUEST_COMPLETED", false)
        val imageView = findViewById<ImageView>(R.id.scroll1)

        if (isQuestCompleted) {
            imageView.setBackgroundResource(R.drawable.clear)
        } else {
            imageView.setBackgroundResource(R.drawable.quest3)
        }


        val questbtn1 = findViewById<Button>(R.id.quest1)
        questbtn1.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest1)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val questbtn2 = findViewById<Button>(R.id.quest2)
        questbtn2.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest2)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val questbtn3 = findViewById<Button>(R.id.quest3)
        questbtn3.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest3)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val questbtn4 = findViewById<Button>(R.id.quest4)
        questbtn4.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest4)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val questbtn5 = findViewById<Button>(R.id.quest5)
        questbtn5.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest5)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

//        val questIds = arrayOf(R.id.quest1, R.id.quest2, R.id.quest3, R.id.quest4, R.id.quest5)
//
//        for (questId in questIds) {
//            val detailQuest = findViewById<Button>(questId)
//            detailQuest.setOnClickListener {
//                val questData = when (questId) {
//                    R.id.quest1 -> quest1
//                    R.id.quest2 -> quest2
//                    R.id.quest3 -> quest3
//                    R.id.quest4 -> quest4
//                    R.id.quest5 -> quest5
//                    else -> null
//                }
//
//                if (questData != null) {
//                    val intent = Intent(this, DetailQuestActivity::class.java)
//                    intent.putExtra("QUESTDATA", questData)
//                    startActivity(intent)
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//                }
//            }
//        }
// 보상 선택시 토스트로 출력
//        val resultbtn1 = findViewById<Button>(R.id.questResult1)
//        resultbtn1.setOnClickListener {
//            Toast.makeText(this, "보상은 ** 입니다.", Toast.LENGTH_SHORT).show()
//        }
//
//        val resultbtn2 = findViewById<Button>(R.id.questResult2)
//        resultbtn2.setOnClickListener {
//            Toast.makeText(this, "보상은 ** 입니다.", Toast.LENGTH_SHORT).show()
//        }
//
//        val resultbtn3 = findViewById<Button>(R.id.questResult3)
//        resultbtn3.setOnClickListener {
//            Toast.makeText(this, "보상은 ** 입니다.", Toast.LENGTH_SHORT).show()
//        }
//
//        val resultbtn4 = findViewById<Button>(R.id.questResult4)
//        resultbtn4.setOnClickListener {
//            Toast.makeText(this, "보상은 ** 입니다.", Toast.LENGTH_SHORT).show()
//        }
//
//        val resultbtn5 = findViewById<Button>(R.id.questResult5)
//        resultbtn5.setOnClickListener {
//            Toast.makeText(this, "보상은 ** 입니다.", Toast.LENGTH_SHORT).show()
//        }

// 보상 선택시 액티비티 전환
        val resultbtn1 = findViewById<Button>(R.id.questResult1)
        resultbtn1.setOnClickListener {
            var intent = Intent(this, ResultActivity::class.java)
//            intent putExtra("RESULTDATA", result1)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}


