package com.coffeeing.client.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import coil.load
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityDetailBinding
import com.coffeeing.client.presentation.create.CreateActivity.Companion.DIALOG
import com.coffeeing.client.presentation.home.HomeActivity.Companion.ID
import com.coffeeing.client.util.UiState
import com.coffeeing.client.util.binding.BindingActivity
import com.coffeeing.client.util.binding.BindingCoffeeingDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initLayout()
        addListeners()
        collectData()
    }

    private fun initLayout() {
        viewModel.getCoffeeingDetail(intent.getIntExtra(ID, 0))

        bindingData()
    }

    private fun addListeners() {
        binding.ivDetailBackArrow.setOnClickListener {
            finish()
        }

        binding.btnDetailSubmit.setOnClickListener {
            viewModel.postRegistration(intent.getIntExtra(ID, 0))
        }

        binding.ivDetailLikeButton.setOnClickListener {
            viewModel.postLike(intent.getIntExtra(ID, 0))
        }
    }

    private fun collectData() {
        viewModel.coffeeingDetail.flowWithLifecycle(lifecycle).onEach {
            bindingData()
        }.launchIn(lifecycleScope)

        viewModel.likeState.flowWithLifecycle(lifecycle).onEach { like ->
            viewModel.getCoffeeingDetail(intent.getIntExtra(ID, 0))
        }.launchIn(lifecycleScope)

        viewModel.registrationState.flowWithLifecycle(lifecycle).onEach {
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
            title = getString(R.string.dialog_title, viewModel.coffeeingDetail.value?.title),
            context = getString(R.string.dialog_submit_context),
            clickBtn = { }
        ).show(supportFragmentManager, DIALOG)
    }

    private fun bindingData() {
        viewModel.coffeeingDetail.value?.let { detailCoffeeing ->
            with(binding) {
                ivDetailImage.load(detailCoffeeing.image)
                tvDetailLikeNum.text = detailCoffeeing.like.toString()
                if (detailCoffeeing.tag == "original") chipItemDetailBaristaOriginal.visibility =
                    View.VISIBLE
                else chipItemDetailBaristaOriginal.visibility = View.GONE
                if (detailCoffeeing.tag == "friend") chipItemDetailLocalArea.visibility =
                    View.VISIBLE
                else chipItemDetailLocalArea.visibility = View.GONE
                if (detailCoffeeing.tag == "tour") chipItemDetailHotPlace.visibility =
                    View.VISIBLE
                else chipItemDetailHotPlace.visibility = View.GONE
                if (detailCoffeeing.tag == "worker") chipItemDetailProfessional.visibility =
                    View.VISIBLE
                else chipItemDetailProfessional.visibility = View.GONE
                if (detailCoffeeing.tag == "beginner") chipItemDetailBeginner.visibility =
                    View.VISIBLE
                else chipItemDetailBeginner.visibility = View.GONE
                tvDetailTitle.text = detailCoffeeing.title
                tvDetailLocation.text = detailCoffeeing.district
                tvDetailTime.text = detailCoffeeing.meetTime
                tvDetailRecruit.text =
                    getString(R.string.home_coffeeing_person, detailCoffeeing.numPeople)
                tvDetailNickname.text = detailCoffeeing.organizer
                tvDetailCount.text = getString(R.string.detail_count, 3)
                tvDetailIntroText.text = detailCoffeeing.content
                tvDetailCountdownContent.text =
                    detailCoffeeing.deadlineYY + "-" + detailCoffeeing.deadlineMM + "-" + detailCoffeeing.deadlineDD
                if (detailCoffeeing.iflike) ivDetailLikeButton.setImageResource(R.drawable.ic_home_fill_heart)
                else ivDetailLikeButton.setImageResource(R.drawable.ic_home_stroke_heart)
            }
        }
    }
}