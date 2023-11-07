package com.coffeeing.client.presentation.dummy.create

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityCreateBinding
import com.coffeeing.client.presentation.dummy.DummyActivity

class CreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateBinding

    private var isButtonClicked1 = false // 카테고리 버튼
    private var isButtonClicked2 = false
    private var isButtonClicked3 = false
    private var isButtonClicked4 = false
    private var isButtonClicked5 = false

    // 뷰 생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater) //activity_create.xml을 객체로 만들어줌
        setContentView(binding.root) // binding으로 연결한 뷰를 보여줌

        // Submit 버튼 클릭 시 AlertDialog 표시
        binding.submitButton.setOnClickListener {
            showSubmitAlertDialog()
        }

        binding.previousImage.setOnClickListener {
            finish() // 현재 액티비티를 종료하여 이전 액티비티로 돌아감
        }

        // Submit 버튼의 배경색 및 텍스트 색상 토글 효과
        binding.toggle1.setOnClickListener {
            isButtonClicked1 = !isButtonClicked1 // 버튼 1 상태를 토글
            updateButtonState(binding.toggle1, isButtonClicked1)
        }

        binding.toggle2.setOnClickListener {
            isButtonClicked2 = !isButtonClicked2
            updateButtonState(binding.toggle2, isButtonClicked2)
        }

        binding.toggle3.setOnClickListener {
            isButtonClicked3 = !isButtonClicked3
            updateButtonState(binding.toggle3, isButtonClicked3)
        }

        binding.toggle4.setOnClickListener {
            isButtonClicked4 = !isButtonClicked4
            updateButtonState(binding.toggle4, isButtonClicked4)
        }

        binding.toggle5.setOnClickListener {
            isButtonClicked5 = !isButtonClicked5
            updateButtonState(binding.toggle5, isButtonClicked5)
        }

    }

    fun showDatePickerDialog(view: View) {
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }

    private fun showSubmitAlertDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle(R.string.dialog_title)
        dialogBuilder.setMessage(R.string.dialog_content)
        dialogBuilder.setPositiveButton(R.string.check) { dialog, which ->
            // "OK" 버튼을 클릭했을 때 이동할 화면 또는 작업을 추가
            navigateToPostView()
        }
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }

    private fun navigateToPostView() {
        // 게시물을 보여주는 화면으로 이동(임시로 DummyActivity로)
        val intent = Intent(this, DummyActivity::class.java)
        startActivity(intent)
    }

    private fun updateButtonState(button: Button, isClicked: Boolean) {
        // 버튼 상태에 따라 배경 및 텍스트 색상 변경
        if (isClicked) {
            button.setBackgroundResource(R.drawable.button_selector_clicked)
            button.setTextColor(resources.getColor(R.color.white))
        } else {
            button.setBackgroundResource(R.drawable.button_selector)
            button.setTextColor(resources.getColor(R.color.point_1))
        }
    }
}