package com.coffeeing.client.presentation.detail

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityDetailBinding
import com.coffeeing.client.presentation.home.HomeActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private var likeButtonClicked = false // 카테고리 버튼

    // 뷰 생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Submit 버튼 클릭 시 AlertDialog 표시
        binding.bDetailSubmitButton.setOnClickListener {
            showSubmitAlertDialog()
        }

        binding.ibDetailBackArrow.setOnClickListener {
            finish() // 현재 액티비티를 종료하여 이전 액티비티로 돌아감
        }

        binding.tbDetailLikeButton.setOnClickListener {
            likeButtonClicked = !likeButtonClicked // 버튼 1 상태를 토글
            updateButtonState(binding.tbDetailLikeButton, likeButtonClicked)
        }

    }

    private fun showSubmitAlertDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle(R.string.detail1_title)
        dialogBuilder.setMessage(R.string.dialog_content)
        dialogBuilder.setPositiveButton(R.string.check) { dialog, which ->
            navigateToPostView()
        }
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }

    private fun navigateToPostView() {
        // 게시물을 보여주는 화면으로 이동
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun updateButtonState(button: Button, isClicked: Boolean) {
        // 버튼 상태에 따라 배경 및 텍스트 색상 변경
        if (isClicked) {
            button.setBackgroundResource(R.drawable.like_button_selector_clicked)
            button.setTextColor(resources.getColor(R.color.point_3))
        } else {
            button.setBackgroundResource(R.drawable.like_button_selector)
            button.setTextColor(resources.getColor(R.color.point_1))
        }
    }
    
    // 가짜 데이터
    private val mockDetailButtonList =listOf<DetailButton>(
        DetailButton(
            button_name = "바리스타 오리지널",
            button_num = 0,
        ),

        DetailButton(
            button_name = "동네친구끼리 편하게",
            button_num = 0,
        ),

        DetailButton(
            button_name = "핫플 카페 투어",
            button_num = 0,
        ),
    )
}