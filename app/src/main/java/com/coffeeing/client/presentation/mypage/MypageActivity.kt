package com.coffeeing.client.presentation.mypage

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityMyPageBinding
import com.coffeeing.client.presentation.detail.DetailActivity
import com.coffeeing.client.presentation.home.HomeActivity
import com.coffeeing.client.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MypageActivity : BindingActivity<ActivityMyPageBinding>(R.layout.activity_my_page) {
    private val viewModel: MypageViewModel by viewModels()
    lateinit var mypageCoffeeingAdapter: MypageCoffeeingClubAdapter
    lateinit var mypageCoffeeingApplyAdapter: MypageCoffeeingApplyAdapter
    lateinit var mypageCoffeeingLikeAdapter: MypageCoffeeingLikeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        addListeners()
        initLayout()
        collectData()
    }

    private fun addListeners() {
        binding.ibMypageBackArrow.setOnClickListener {
            finish()
        }
    }

    private fun initLayout() {
        viewModel.getMyclubList()
        viewModel.getMyapplyList()
        viewModel.getMylikeList()

        mypageCoffeeingAdapter = MypageCoffeeingClubAdapter(::moveToDetail)
        binding.rvMypageHostCoffeeing.adapter = mypageCoffeeingAdapter
        mypageCoffeeingAdapter.submitList(viewModel.myclubList.value)

        mypageCoffeeingApplyAdapter = MypageCoffeeingApplyAdapter(::moveToDetail)
        binding.rvMypageApplyCoffeeing.adapter = mypageCoffeeingApplyAdapter
        mypageCoffeeingApplyAdapter.submitList(viewModel.myapplyList.value)

        mypageCoffeeingLikeAdapter = MypageCoffeeingLikeAdapter(::moveToDetail)
        binding.rvMypageLikeCoffeeing.adapter = mypageCoffeeingLikeAdapter
        mypageCoffeeingLikeAdapter.submitList(viewModel.mylikeList.value)

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

        viewModel.myapplyList.flowWithLifecycle(lifecycle).onEach {
            mypageCoffeeingApplyAdapter.submitList(viewModel.myapplyList.value)
            viewModel.getMyapplyList()
        }.launchIn(lifecycleScope)

        viewModel.mylikeList.flowWithLifecycle(lifecycle).onEach {
            mypageCoffeeingLikeAdapter.submitList(viewModel.mylikeList.value)
            viewModel.getMyclubList()
        }.launchIn(lifecycleScope)
    }

    companion object {
        const val NICKNAME = "커피조아"
    }
}
