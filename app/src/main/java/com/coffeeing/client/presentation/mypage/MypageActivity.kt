package com.coffeeing.client.presentation.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityMyPageBinding
import com.coffeeing.client.presentation.detail.DetailActivity
import com.coffeeing.client.presentation.home.HomeActivity
import com.coffeeing.client.util.UiState
import com.coffeeing.client.util.binding.BindingActivity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class MypageActivity : BindingActivity<ActivityMyPageBinding>(R.layout.activity_my_page) {
    private val viewModel: MypageViewModel by viewModels()
    private lateinit var mypageHostCoffeeingAdapter: MypageCoffeeingAdapter
    private lateinit var mypageApplyCoffeeingAdapter: MypageCoffeeingAdapter
    private lateinit var mypageLikeCoffeeingAdapter: MypageCoffeeingAdapter

    lateinit var mypageCoffeeingAdapter: MypageCoffeeingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initLayout()
        collectData()
    }

    private fun initLayout() {
        viewModel.getMyclubList()

        mypageHostCoffeeingAdapter = MypageCoffeeingAdapter(::moveToDetail)


        binding.rvMypageHostCoffeeing.adapter = mypageHostCoffeeingAdapter


        mypageHostCoffeeingAdapter.submitList(viewModel.myclubList.value)


        with(binding) {
            tvMypageProfileName.text = NICKNAME
            tvMypageFavoriteTitleName.text = NICKNAME
        }
    }

    private fun moveToDetail(id: Int) {
        Intent(this, DetailActivity::class.java).apply {
            putExtra(HomeActivity.ID, id)
            startActivity(this)
        }
    }
    private fun collectData() {
        viewModel.myclubList.flowWithLifecycle(lifecycle).onEach {
            mypageCoffeeingAdapter.submitList(viewModel.myclubList.value)
            viewModel.getMyclubList()
        }.launchIn(lifecycleScope)
    }

    companion object {
        const val NICKNAME = "커피조아"
    }
}
