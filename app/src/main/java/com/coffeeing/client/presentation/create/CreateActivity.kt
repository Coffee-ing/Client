package com.coffeeing.client.presentation.create

import android.content.Intent
import android.os.Bundle
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityCreateBinding
import com.coffeeing.client.presentation.home.HomeActivity
import com.coffeeing.client.util.binding.BindingActivity
import com.coffeeing.client.util.binding.BindingCoffeeingDialogFragment

class CreateActivity : BindingActivity<ActivityCreateBinding>(R.layout.activity_create) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.ivCreateArrowLeft.setOnClickListener {
            finish()
        }

        binding.ivCreateClosingDate.setOnClickListener {
            DatePickerFragment().show(supportFragmentManager, DATE_PICKER)
        }

        binding.btnCreateApplyCoffeeing.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        BindingCoffeeingDialogFragment(
            title = getString(R.string.dialog_title, binding.etCreateTitle.text.toString()),
            context = getString(R.string.dialog_create_context),
            clickBtn = { moveToHome() }
        ).show(supportFragmentManager, DIALOG)
    }

    private fun moveToHome() {
        Intent(this@CreateActivity, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(this)
            finish()
        }
    }

    companion object {
        const val DATE_PICKER = "datePicker"
        const val DIALOG = "dialog"
    }
}