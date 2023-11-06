package com.coffeeing.client.presentation.dummy

import android.os.Bundle
import androidx.activity.viewModels
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityDummyBinding
import com.coffeeing.client.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DummyActivity : BindingActivity<ActivityDummyBinding>(R.layout.activity_dummy) {
    private val viewModel: DummyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    private fun initLayout() {
        TODO("Not yet implemented")
    }

    private fun addListeners() {
        TODO("Not yet implemented")
    }

    private fun addObservers() {
        TODO("Not yet implemented")
    }
}