package com.coffeeing.client.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityHomeBinding
import com.coffeeing.client.presentation.create.CreateActivity
import com.coffeeing.client.presentation.detail.DetailActivity
import com.coffeeing.client.presentation.mypage.MypageActivity
import com.coffeeing.client.presentation.type.HomeSortType
import com.coffeeing.client.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val viewModel: HomeViewModel by viewModels()
    lateinit var homeCoffeeingAdapter: HomeCoffeeingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initLayout()
        addListeners()
        addObservers()
        collectData()
    }

    private fun initLayout() {
        viewModel.getHomeList()

        homeCoffeeingAdapter = HomeCoffeeingAdapter(::moveToDetail, ::postLike)
        binding.rvHomeCoffeeing.adapter = homeCoffeeingAdapter
        homeCoffeeingAdapter.submitList(viewModel.homeList.value)

        if (viewModel.homeList.value.isNullOrEmpty()) {
            binding.rvHomeCoffeeing.visibility = View.INVISIBLE
            binding.layoutHomeEmpty.visibility = View.VISIBLE
        } else {
            binding.rvHomeCoffeeing.visibility = View.VISIBLE
            binding.layoutHomeEmpty.visibility = View.INVISIBLE
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

        binding.ivHomeSearch.setOnClickListener {
            viewModel.getSearch(binding.etHomeSearch.text.toString())
        }
    }

    private fun addObservers() {
        viewModel.homeSort.observe(this) { homeSortType ->
            binding.tvHomeSort.text =
                viewModel.homeSort.value?.sortType ?: HomeSortType.RECENT.sortType
        }
    }

    private fun collectData() {
        viewModel.homeList.flowWithLifecycle(lifecycle).onEach {
            homeCoffeeingAdapter.submitList(viewModel.homeList.value)

            if (viewModel.homeList.value.isNullOrEmpty()) {
                binding.rvHomeCoffeeing.visibility = View.INVISIBLE
                binding.layoutHomeEmpty.visibility = View.VISIBLE
            } else {
                binding.rvHomeCoffeeing.visibility = View.VISIBLE
                binding.layoutHomeEmpty.visibility = View.INVISIBLE
            }
        }.launchIn(lifecycleScope)

        viewModel.likeState.flowWithLifecycle(lifecycle).onEach {
            viewModel.getHomeList()
        }.launchIn(lifecycleScope)
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
        val lastItem = viewModel.homeList.value?.lastOrNull()
        if (lastItem != null) {
            Intent(this@HomeActivity, CreateActivity::class.java).apply {
                putExtra(ID, lastItem.id)
                startActivity(this)
            }
        }
    }

    private fun moveToDetail(id: Int) {
        Intent(this, DetailActivity::class.java).apply {
            putExtra(ID, id)
            startActivity(this)
        }
    }

    private fun postLike(postId: Int) {
        viewModel.postLike(postId)
    }

    private fun moveToMypage() {
        Intent(this@HomeActivity, MypageActivity::class.java).apply {
            startActivity(this)
        }
    }

    companion object {
        const val HOME_SORT_DIALOG = "homeSortDialog"
        const val ID = "id"
    }
}