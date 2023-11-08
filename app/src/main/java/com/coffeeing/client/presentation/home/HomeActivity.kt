package com.coffeeing.client.presentation.home

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityHomeBinding
import com.coffeeing.client.util.binding.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val viewModel: HomeViewModel by viewModels()
    lateinit var homeCoffeeingAdapter: HomeCoffeeingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
        initLayout()
    }

    private fun initLayout() {
        homeCoffeeingAdapter = HomeCoffeeingAdapter()
        binding.rvHomeCoffeeing.adapter = homeCoffeeingAdapter
        homeCoffeeingAdapter.submitList(viewModel.mockHomeCoffeeingList)

        if (viewModel.mockHomeCoffeeingList.isEmpty()) {
            binding.rvHomeCoffeeing.visibility = View.INVISIBLE
            binding.layoutHomeEmpty.visibility = View.VISIBLE
        }
    }
}