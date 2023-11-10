package com.coffeeing.client.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityHomeBinding
import com.coffeeing.client.domain.model.Coffeeing
import com.coffeeing.client.presentation.create.CreateActivity
import com.coffeeing.client.presentation.detail.DetailActivity
import com.coffeeing.client.presentation.mypage.MypageActivity
import com.coffeeing.client.presentation.type.HomeSortType
import com.coffeeing.client.util.binding.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val viewModel: HomeViewModel by viewModels()
    lateinit var homeCoffeeingAdapter: HomeCoffeeingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initLayout()
        addListeners()
        addObservers()
    }

    private fun initLayout() {
        homeCoffeeingAdapter = HomeCoffeeingAdapter(::moveToDetail)
        binding.rvHomeCoffeeing.adapter = homeCoffeeingAdapter
        homeCoffeeingAdapter.submitList(viewModel.mockHomeCoffeeingList)

        if (viewModel.mockHomeCoffeeingList.isEmpty()) {
            binding.rvHomeCoffeeing.visibility = View.INVISIBLE
            binding.layoutHomeEmpty.visibility = View.VISIBLE
        }

        binding.tvHomeSort.text = viewModel.homeSort.value?.sortType ?: HomeSortType.RECENT.sortType
    }

    private fun addListeners() {
        binding.layoutHomeSort.setOnClickListener {
            showHomeSortDialog()
        }

        binding.tvHomeAddCoffeeing.setOnClickListener {
            moveToCreate()
        }

        binding.ivHomeMyPage.setOnClickListener {
            moveToMypage()
        }
    }

    private fun addObservers() {
        viewModel.homeSort.observe(this) { homeSortType ->
            binding.tvHomeSort.text =
                viewModel.homeSort.value?.sortType ?: HomeSortType.RECENT.sortType
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

    private fun moveToCreate() {
        Intent(this@HomeActivity, CreateActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun moveToDetail(coffeeing: Coffeeing) {
        Intent(this, DetailActivity::class.java).apply {
            putExtra(COFFEEING, coffeeing.toParcelizeCoffeeing())
            startActivity(this)
        }
    }

    private fun moveToMypage() {
        Intent(this@HomeActivity, MypageActivity::class.java).apply {
            startActivity(this)
        }
    }

    companion object {
        const val HOME_SORT_DIALOG = "homeSortDialog"
        const val COFFEEING = "coffeeing"
    }
}