package com.example.retroquest

import android.app.Activity
import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.util.Date
import java.util.Locale

class ComunityActivity : AppCompatActivity() {
   private val postList = mutableListOf<PostData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunity)


//        val postListLayout = findViewById<LinearLayout>(R.id.postListLayout)



//         val inflater = LayoutInflater.from(this)
//        for (post in postList){
//            val itemView = inflater.inflate(R.layout.post_item,postListLayout,false)
//
//            val postTitleView =itemView.findViewById<TextView>(R.id.postTitleTextView)
//            val postContentTextView = itemView.findViewById<TextView>(R.id.postContentTextView)
//            val postFullContentTextView = itemView.findViewById<TextView>(R.id.postFullContentTextView)
//
//            postTitleView.text =post.title
//            postContentTextView.text = post.author
//            postFullContentTextView.text = post.fullContent
//
//            itemView.setOnClickListener{
//                postFullContentTextView.visibility  = View.VISIBLE
//            }
//            postListLayout.addView(itemView)
//        }

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

            postList.add(PostData(title!!, author!!, content!!, date!!)) // 리스트에 아이템 추가

            updatePostList() // 아이템 목록 갱신
        }
    }

    private fun updatePostList() {
        val postListLayout = findViewById<LinearLayout>(R.id.postListLayout)
         postListLayout.removeAllViews()

        val inflater = LayoutInflater.from(this)
        for (post in postList) {
            val itemView = inflater.inflate(R.layout.post_item, postListLayout, false)
            val postTitleView = itemView.findViewById<TextView>(R.id.postTitleTextView)
            val postContentTextView = itemView.findViewById<TextView>(R.id.postContentTextView)
            val postFullContentTextView = itemView.findViewById<TextView>(R.id.postFullContentTextView)

            val formattedDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(
                Date()
            )

            postTitleView.text = "제목 : ${post.title}"
            postContentTextView.text = "작성자 : ${post.author}"
            postFullContentTextView.text ="내용 : ${post.fullContent}\n입력한시간 : ${formattedDate}"

            itemView.setOnClickListener {
                postFullContentTextView.visibility = View.VISIBLE
            }
            postListLayout.addView(itemView)
        }
    }

    companion object {
        const val REQUEST_ADD_POST = 1
    }
}