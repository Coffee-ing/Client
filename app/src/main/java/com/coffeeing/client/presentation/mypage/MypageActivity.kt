package com.coffeeing.client.presentation.mypage

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityMyPageBinding
import com.coffeeing.client.presentation.home.HomeCoffeeingAdapter
import com.coffeeing.client.presentation.home.HomeSortBottomSheetDialog
import com.coffeeing.client.presentation.type.HomeSortType
import com.coffeeing.client.util.binding.BindingActivity


class MypageActivity : BindingActivity<ActivityMyPageBinding>(R.layout.activity_my_page) {
    private val viewModel: MypageViewModel by viewModels()
    lateinit var mypageCoffeeingAdapter: MypageCoffeeingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initLayout()
    }

    private fun initLayout() {
        mypageCoffeeingAdapter = MypageCoffeeingAdapter()
        binding.rvMypageHostCoffeeing.adapter = mypageCoffeeingAdapter
        binding.rvMypageApplyCoffeeing.adapter = mypageCoffeeingAdapter
        binding.rvMypageLikeCoffeeing.adapter = mypageCoffeeingAdapter
        mypageCoffeeingAdapter.submitList(viewModel.mockHomeCoffeeingList)

        if (viewModel.mockHomeCoffeeingList.isEmpty()) {
            binding.rvMypageHostCoffeeing.visibility = View.INVISIBLE
        }
    }

    private fun showHomeSortDialog() {
        viewModel.homeSort.value?.let {
            HomeSortBottomSheetDialog(
                currentSortType = it,
                sort = { sortType -> viewModel.setHomeSort(sortType) }
            ).show(supportFragmentManager, HOME_SORT_DIALOG)
        }
    }

    companion object {
        const val HOME_SORT_DIALOG = "homeSortDialog"
    }
}