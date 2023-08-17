package com.example.retroquest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class GameActivity : AppCompatActivity(), View.OnClickListener {

    private val buttons: Array<ImageButton?> = arrayOfNulls<ImageButton>(12)
    private lateinit var imageList: ArrayList<Int>
    private lateinit var cards: ArrayList<GameCard>
    private lateinit var resultText: TextView//결과
    private var preCardPosition: Int = -1 //이전카드 위치

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        resultText = findViewById(R.id.resultText)
        val resetButton = findViewById<Button>(R.id.resetBtn)
        resetButton.setOnClickListener {
            init()//셋팅
        }
        init()//셋팅
    }//oncreate

    private fun init() {

        imageList = ArrayList()//초기화해주깅

        cards = ArrayList()//zz카드초기화

        imageList.add(R.drawable.picachu)
        imageList.add(R.drawable.richu)
        imageList.add(R.drawable.pairy)
        imageList.add(R.drawable.pariy2)
        imageList.add(R.drawable.picachu)
        imageList.add(R.drawable.richu)
        imageList.add(R.drawable.pairy)
        imageList.add(R.drawable.pariy2)
        imageList.add(R.drawable.gobuk1)
        imageList.add(R.drawable.gobuk2)
        imageList.add(R.drawable.gobuk1)
        imageList.add(R.drawable.gobuk2)


        imageList.shuffle()
        for ((index, item) in buttons.withIndex()) {

            //버튼아이디
            val buttonId = "imageBtn${index}"
            //리소스아이디
            val resource: Int = resources.getIdentifier(buttonId, "id", packageName)

            buttons[index] = findViewById(resource)//버튼초기화

            buttons[index]?.setOnClickListener(this)//d이벤트적용

            cards.add(GameCard(imageList[index], false, false))

            buttons[index]?.setImageResource(R.drawable.poketball)//버튼에 이미지담기

            //선명도
            buttons[index]?.alpha = 1.0f

        }
    }

    //클릭이벤트
    override fun onClick(view: View?) {

        val id: Int? = view?.id

        var position: Int = 0
        when (id) {

            R.id.imageBtn0 -> position = 0
            R.id.imageBtn1 -> position = 1
            R.id.imageBtn2 -> position = 2
            R.id.imageBtn3 -> position = 3
            R.id.imageBtn4 -> position = 4
            R.id.imageBtn5 -> position = 5
            R.id.imageBtn6 -> position = 6
            R.id.imageBtn7 -> position = 7
            R.id.imageBtn8 -> position = 8
            R.id.imageBtn9 -> position = 9
            R.id.imageBtn10 -> position = 10
            R.id.imageBtn11 -> position = 11
        }
        // 업데이트모델
        updateModel(position)
//업데이트뷰
        updateView(position)

    }

    private fun updateModel(position: Int) {

        var card: GameCard = cards[position]
        //뒤집고 다시 클릭하는 거 방지
        if (card.isFaceUp) {
            Toast.makeText(this, "이미 뒤집은거야~", Toast.LENGTH_SHORT).show()
            return
        }
        //뒤집힌카드 이전에 뒤집힌카드 0또는 2개일때

        if (preCardPosition == -1) {
            restoreCard()
            preCardPosition = position
        } else {//이전에 뒤집힌 카드가 1개일때 //카드비교
            checkForMatch(preCardPosition, position)
            preCardPosition = -1
        }

//반대 값을 넣기(앞면->뒷면, 뒷면->앞면)
        cards[position].isFaceUp = !card.isFaceUp
    }

    private fun updateView(position: Int) {

        var card: GameCard = cards[position]
        //뒤집었으면 랜덤이미지보여준다
        if (card.isFaceUp) {
            buttons[position]?.setImageResource(card.imageId)

        } else {
            buttons[position]?.setImageResource(R.drawable.poketball)
        }
    }

    private fun restoreCard() {
        for ((index, item) in cards.withIndex()) {
            //매치않은zke카드
            if (!cards[index].isMatched) {
                buttons[index]?.setImageResource(R.drawable.poketball)
                //데이터수정
                cards[index].isFaceUp = false
            }
        }
    }

    //카드이미지;비교

    private fun checkForMatch(prePosition: Int, position: Int) {
        //처음 카드와 두 번째 카드 이미지가 같다면
        if (cards[prePosition].imageId == cards[position].imageId) {
            resultText.text = "매치 성공!!"

            //매치변경
            cards[prePosition].isMatched = true
            cards[position].isMatched = true

            //색상변경
            buttons[prePosition]?.alpha = 0.1f
            buttons[position]?.alpha = 0.1f

            //완료체크
            checkCompletion()
        } else {
            resultText.text = "매치실패!!!!"
        }
    }

    private fun checkCompletion() {
        var count: Int = 0
        for ((index, item) in cards.withIndex()) {
            if (cards[index].isMatched) {
                count++
            }
        }
        //매치 ㅋ갯수가 카드 갯수가 같다면 완료
        if (count == cards.size) {
            resultText.text = "게임완료"
        }
    }
}