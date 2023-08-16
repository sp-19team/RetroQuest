package com.example.retroquest

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import pl.droidsonroids.gif.GifDrawable
import java.util.Date
import java.util.Locale

class ComunityActivity : AppCompatActivity() {
   private val postList = mutableListOf<PostData>()
    private lateinit var moveLinear: View

    private var isAnimating = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunity)

        moveLinear = findViewById<LinearLayout>(R.id.moveLinear)
        startAnimation()

        //gif두개 설정한거임 ㅋㅋ_ㅋ
        val gifImageView = findViewById<ImageView>(R.id.alertIcon)
        val gifDrawable = GifDrawable(resources, R.drawable.alert)
        gifImageView.setImageDrawable(gifDrawable)
        gifDrawable.start()

        val gifImageView2 =findViewById<ImageView>(R.id.alertIcon2)
        val gifDrawable2 = GifDrawable(resources, R.drawable.alert)
        gifImageView2.setImageDrawable(gifDrawable2)
        gifDrawable2.start()
    }






    private fun startAnimation() {
        if (isAnimating) return
        isAnimating = true

        animateNoticeTextView(0f, 1000f)
    }

    private fun animateNoticeTextView(startX: Float, endX: Float) {
        moveLinear.translationX = startX
        moveLinear.alpha = 1f
        moveLinear.animate()
            .translationX(endX)
            .alpha(0f)
            .setDuration(7000) // 애니메이션 지속 시간을 조정해 천천히 진행하도록 설정
            .withEndAction {
                if (!isFinishing) {
                    moveLinear.translationX = -1000f
                    animateBackIn()
                }
            }
            .start()
    }

    private fun animateBackIn() {
        moveLinear.alpha = 1f
        moveLinear.animate()
            .translationX(0f)
            .setDuration(6000) // 애니메이션 지속 시간을 조정해 천천히 진행하도록 설정
            .withEndAction {
                if (!isFinishing) {
                    animateNoticeTextView(0f, 1000f)
                }
            }
            .start()
    }

    override fun onPause() {
        super.onPause()
        moveLinear.clearAnimation()
        isAnimating = false
    }

    override fun onResume() {
        super.onResume()
        startAnimation()

//혹시모르니깐 임의로 나둔거 나중에 최종일 때 삭제예정
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