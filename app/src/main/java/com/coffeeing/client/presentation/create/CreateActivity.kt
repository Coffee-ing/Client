package com.coffeeing.client.presentation.create

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityCreateBinding
import com.coffeeing.client.presentation.home.HomeActivity
import com.coffeeing.client.util.UiState
import com.coffeeing.client.util.binding.BindingActivity
import com.coffeeing.client.util.binding.BindingCoffeeingDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CreateActivity : BindingActivity<ActivityCreateBinding>(R.layout.activity_create) {
    private val viewModel: CreateViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        addListeners()
        collectData()
    }

    private fun addListeners() {
        binding.ivCreateArrowLeft.setOnClickListener {
            finish()
        }

        binding.ivCreateClosingDate.setOnClickListener {
            DatePickerFragment().show(supportFragmentManager, DATE_PICKER)
        }

        binding.btnCreateApplyCoffeeing.setOnClickListener {
            viewModel.postCoffeeing(
                id = 22,
                title = binding.etCreateTitle.text.toString(),
                district = binding.etCreateLocation.text.toString(),
                meetTime = binding.etCreateDayDate.text.toString(),
                numPeople = binding.etCreatePerson.text.toString().toInt(),
                date = binding.etCreateClosingDate.text.toString(),
                tag = when (binding.cgCreateCategory.checkedChipId) {
                    R.id.chip_create_original -> "original"
                    R.id.chip_create_friend -> "friend"
                    R.id.chip_create_tour -> "tour"
                    R.id.chip_create_worker -> "worker"
                    R.id.chip_create_beginner -> "beginner"
                    else -> "original"
                },
                context = binding.etCreateContext.text.toString()
            )
        }
    }

    private fun collectData() {
        viewModel.postCoffeeingState.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    showDialog()
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
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