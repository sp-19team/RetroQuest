//package com.example.retroquest
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AlertDialog
//import androidx.appcompat.app.AppCompatActivity
//
//class DetailPostActivity : AppCompatActivity() {
//
//
//    private var postList: MutableList<PostData> = mutableListOf()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail_post)
//
//        val editButton = findViewById<Button>(R.id.editBtn)
//        val deleteButton = findViewById<Button>(R.id.deleteBtn)
//
//
//
//        // 상세 정보 받아오기
//        val title = intent.getStringExtra("TITLE")
//        val author = intent.getStringExtra("AUTHOR")
//        val content = intent.getStringExtra("CONTENT")
//        val date = intent.getStringExtra("DATE")
//        val selectedImg = intent.getIntExtra("IMAGE", 0)
//
//        // Xㅌxml 레이아웃의 뷰와 연결
//        val titleTextView = findViewById<TextView>(R.id.titleTextView)
//        val characterImageView = findViewById<ImageView>(R.id.characterImageView)
//        val authorTextView = findViewById<TextView>(R.id.authorTextView)
//        val contentTextView = findViewById<TextView>(R.id.contentTextView)
//        val dateView = findViewById<TextView >(R.id.dateTextView)
//        // 받아온 데이터로 뷰 설정
//        titleTextView.text = title
//        characterImageView.setImageResource(when (selectedImg) {
//            1 -> R.drawable.sonci3
//            2 -> R.drawable.mario2
//            3 -> R.drawable.picachu
//            4 -> R.drawable.cuvi2
//            else -> R.drawable.cuvi
//        })
//        authorTextView.text = "작성자: $author"
//        dateView.text = date
//        contentTextView.text = content
//
//        editButton.setOnClickListener {
//
//        }
//
//
//        deleteButton.setOnClickListener {
//            val confirmDialog = AlertDialog.Builder(this)
//            confirmDialog.setTitle("게시물 삭제")
//            confirmDialog.setMessage("정말로 이 게시물을 삭제하시겠습니까?")
//            confirmDialog.setPositiveButton("확인") { _, _ ->
//                val deleteIntent = Intent()
//                deleteIntent.putExtra("MODE", "DELETE")
//                deleteIntent.putExtra("TITLE", title)
//                deleteIntent.putExtra("AUTHOR", author)
//                deleteIntent.putExtra("CONTENT", content)
//                deleteIntent.putExtra("IMAGE", selectedImg)
//                setResult(RESULT_OK, deleteIntent)
//                finish()
//            }
//            confirmDialog.setNegativeButton("취소", null)
//            confirmDialog.show()
//        }
//    }
//
//
//
//
//
//    }
//
//
