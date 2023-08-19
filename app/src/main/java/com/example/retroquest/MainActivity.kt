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
        val quest5 = QuestData("코틀린 문법 학습", "코틀린 문법을 공부합니다.", "일일 퀘스트")


        val isQuestCompleted1 = intent.getBooleanExtra("QUEST_COMPLETED1", false)
        val imageView1 = findViewById<ImageView>(R.id.scroll1)

        if (isQuestCompleted1) {
            imageView1.setBackgroundResource(R.drawable.clear)
        } else {
            imageView1.setBackgroundResource(R.drawable.quest3)
        }


        val questbtn1 = findViewById<Button>(R.id.quest1)
        questbtn1.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest1)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val isQuestCompleted2 = intent.getBooleanExtra("QUEST_COMPLETED2", false)
        val imageView2 = findViewById<ImageView>(R.id.scroll2)

        if (isQuestCompleted2) {
            imageView2.setBackgroundResource(R.drawable.clear)
        } else {
            imageView2.setBackgroundResource(R.drawable.quest3)
        }

        val questbtn2 = findViewById<Button>(R.id.quest2)
        questbtn2.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest2)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val isQuestCompleted3 = intent.getBooleanExtra("QUEST_COMPLETED3", false)
        val imageView3 = findViewById<ImageView>(R.id.scroll3)

        if (isQuestCompleted3) {
            imageView3.setBackgroundResource(R.drawable.clear)
        } else {
            imageView3.setBackgroundResource(R.drawable.quest3)
        }

        val questbtn3 = findViewById<Button>(R.id.quest3)
        questbtn3.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest3)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val isQuestCompleted4 = intent.getBooleanExtra("QUEST_COMPLETED4", false)
        val imageView4 = findViewById<ImageView>(R.id.scroll4)

        if (isQuestCompleted4) {
            imageView4.setBackgroundResource(R.drawable.clear)
        } else {
            imageView4.setBackgroundResource(R.drawable.quest3)
        }

        val questbtn4 = findViewById<Button>(R.id.quest4)
        questbtn4.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest4)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val isQuestCompleted5 = intent.getBooleanExtra("QUEST_COMPLETED5", false)
        val imageView5 = findViewById<ImageView>(R.id.scroll5)

        if (isQuestCompleted5) {
            imageView5.setBackgroundResource(R.drawable.clear)
        } else {
            imageView5.setBackgroundResource(R.drawable.quest3)
        }

        val questbtn5 = findViewById<Button>(R.id.quest5)
        questbtn5.setOnClickListener {
            val intent = Intent(this, DetailQuestActivity::class.java)
            intent.putExtra("QUESTDATA", quest5)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }


        val reward1 = ResultData("알고리즘 +1" ,"자신감 +1","실력 +1")
        val reward2 = ResultData("협동력 +1" ,"자신감 +1","실력 +1")
        val reward3 = ResultData("성실함 +1" ,"자신감 +1","실력 +1")
        val reward4 = ResultData("성실함 +1" ,"자신감 +1","실력 +1")
        val reward5 = ResultData("코틀린 +1" ,"자신감 +1","실력 +1")


// 보상 선택시 액티비티 전환
        val resultbtn1 = findViewById<Button>(R.id.questResult1)
        resultbtn1.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULTDATA", reward1)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val resultbtn2 = findViewById<Button>(R.id.questResult2)
        resultbtn2.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULTDATA", reward2)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val resultbtn3 = findViewById<Button>(R.id.questResult3)
        resultbtn3.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULTDATA", reward3)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val resultbtn4 = findViewById<Button>(R.id.questResult4)
        resultbtn4.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULTDATA", reward4)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val resultbtn5 = findViewById<Button>(R.id.questResult5)
        resultbtn5.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULTDATA", reward5)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}

