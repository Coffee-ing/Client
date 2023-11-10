package com.coffeeing.client.presentation.mypage

import android.os.Bundle
import androidx.activity.viewModels
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityMyPageBinding
import com.coffeeing.client.util.binding.BindingActivity


class MypageActivity : BindingActivity<ActivityMyPageBinding>(R.layout.activity_my_page) {
    private val viewModel: MypageViewModel by viewModels()
    private lateinit var mypageHostCoffeeingAdapter: MypageCoffeeingAdapter
    private lateinit var mypageApplyCoffeeingAdapter: MypageCoffeeingAdapter
    private lateinit var mypageLikeCoffeeingAdapter: MypageCoffeeingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initLayout()
    }

    private fun initLayout() {
        mypageHostCoffeeingAdapter = MypageCoffeeingAdapter()
        mypageApplyCoffeeingAdapter = MypageCoffeeingAdapter()
        mypageLikeCoffeeingAdapter = MypageCoffeeingAdapter()

        binding.rvMypageHostCoffeeing.adapter = mypageHostCoffeeingAdapter
        binding.rvMypageApplyCoffeeing.adapter = mypageApplyCoffeeingAdapter
        binding.rvMypageLikeCoffeeing.adapter = mypageLikeCoffeeingAdapter

        mypageHostCoffeeingAdapter.submitList(viewModel.mockHomeCoffeeingList)
        mypageApplyCoffeeingAdapter.submitList(viewModel.mockHomeCoffeeingList)
        mypageLikeCoffeeingAdapter.submitList(viewModel.mockHomeCoffeeingList)

        with(binding) {
            tvMypageProfileName.text = NICKNAME
            tvMypageFavoriteTitleName.text = NICKNAME
        }
    }

    companion object {
        const val NICKNAME = "커피조아"
    }
}
