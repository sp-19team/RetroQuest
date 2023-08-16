package com.example.retroquest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ComunityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunity)


        val postListLayout = findViewById<LinearLayout>(R.id.postListLayout)

        //예제 게시물 데이터
        val postList = listOf(
            PostData("알고리즘어려버요","레벨1푸는데 암걸림 어려움","도아ㅈ줘"),
            PostData("깃허브어려버요","bora","도아ㅈ줘"),
            PostData("깃허브어려버요","bora","도아ㅈ줘"),
            PostData("깃허브어려버요","bora","도아ㅈ줘"),
            PostData("깃허브어려버요","박세준","도아ㅈ줘"),
            PostData("깃허브어려버요","박세준","도아ㅈ줘"),
            PostData("깃허브어려버요","박세준","도아ㅈ줘"),
            PostData("깃허브어려버요","박세준","도아ㅈ줘"),
            PostData("깃허브어려버요","박세준","도아ㅈ줘"),
            PostData("깃허브어려버요","박세준","도아ㅈ줘"),
            PostData("깃허브어려버요","박세준","도아ㅈ줘"),
            PostData("깃허브어려버요","이박세준","도아ㅈ줘"),
            PostData("깃허브어려버요","박세준","도아ㅈ줘")

        )


         val inflater = LayoutInflater.from(this)
        for (post in postList){
            val itemView = inflater.inflate(R.layout.post_item,postListLayout,false)

            val postTitleView =itemView.findViewById<TextView>(R.id.postTitleTextView)
            val postContentTextView = itemView.findViewById<TextView>(R.id.postContentTextView)
            val postFullContentTextView = itemView.findViewById<TextView>(R.id.postFullContentTextView)

            postTitleView.text =post.title
            postContentTextView.text = post.author
            postFullContentTextView.text = post.fullContent

            itemView.setOnClickListener{
                postFullContentTextView.visibility  = View.VISIBLE
            }
            postListLayout.addView(itemView)
        }

        val writeBtn = findViewById<Button>(R.id.writePostButton)
        writeBtn.setOnClickListener {
            val intent = Intent(this, AddPostActivity::class.java)
            startActivityForResult(intent, REQUEST_ADD_POST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ADD_POST && resultCode == Activity.RESULT_OK) {
            val title = data?.getStringExtra("TITLE")
            val author = data?.getStringExtra("AUTHOR")
            val content = data?.getStringExtra("CONTENT")
            val date = data?.getStringExtra("DATE")

            // 이후 출력하거나 다른 처리 수행
            // 예를 들어, TextView에 출력
            val postTitleTextView = findViewById<TextView>(R.id.postTitleTextView)
            val postContentTextView = findViewById<TextView>(R.id.postContentTextView)
            val postFullContentTextView = findViewById<TextView>(R.id.postFullContentTextView)

            postTitleTextView.text = "제목: $title"
            postContentTextView.text = "작성자: $author"
            postFullContentTextView.text = "등록 날짜: $date\n내용: $content"
        }
    }

    companion object {
        const val REQUEST_ADD_POST = 1
    }
}