package com.coffeeing.client.presentation.detail

import android.os.Bundle
import android.view.View
import coil.load
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivityDetailBinding
import com.coffeeing.client.presentation.create.CreateActivity.Companion.DIALOG
import com.coffeeing.client.presentation.home.HomeActivity.Companion.COFFEEING
import com.coffeeing.client.presentation.model.Coffeeing
import com.coffeeing.client.util.binding.BindingActivity
import com.coffeeing.client.util.binding.BindingCoffeeingDialogFragment
import com.coffeeing.client.util.extension.getCompatibleParcelableExtra

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private lateinit var coffeeing: Coffeeing
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        addListeners()
    }

    private fun initLayout() {
        intent.getCompatibleParcelableExtra<Coffeeing>(COFFEEING)?.let {
            coffeeing = it
        }

        with(binding) {
            ivDetailImage.load(coffeeing.coffeeingImg)
            tvDetailLikeNum.text = coffeeing.heartCount.toString()
            if (coffeeing.isBaristaOriginal) chipItemDetailBaristaOriginal.visibility =
                View.VISIBLE
            else chipItemDetailBaristaOriginal.visibility = View.GONE
            if (coffeeing.isLocalArea) chipItemDetailLocalArea.visibility = View.VISIBLE
            else chipItemDetailLocalArea.visibility = View.GONE
            if (coffeeing.isHotPlace) chipItemDetailHotPlace.visibility = View.VISIBLE
            else chipItemDetailHotPlace.visibility = View.GONE
            if (coffeeing.isProfessional) chipItemDetailProfessional.visibility =
                View.VISIBLE
            else chipItemDetailProfessional.visibility = View.GONE
            if (coffeeing.isBeginner) chipItemDetailBeginner.visibility = View.VISIBLE
            else chipItemDetailBeginner.visibility = View.GONE
            tvDetailTitle.text = coffeeing.title
            tvDetailLocation.text = coffeeing.location
            tvDetailTime.text = coffeeing.time
            tvDetailRecruit.text =
                getString(R.string.home_coffeeing_person, coffeeing.person)
            tvDetailNickname.text = coffeeing.writer.nickname
            tvDetailCount.text = getString(R.string.detail_count, coffeeing.writer.numberOfRecruit)
            tvDetailIntroText.text = coffeeing.context
            tvDetailCountdownContent.text = coffeeing.closingDate
            if (coffeeing.isHearted) ivDetailLikeButton.setImageResource(R.drawable.ic_home_fill_heart)
            else ivDetailLikeButton.setImageResource(R.drawable.ic_home_stroke_heart)
        }
    }

    private fun addListeners() {
        binding.ivDetailBackArrow.setOnClickListener {
            finish()
        }

        binding.btnDetailSubmit.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        BindingCoffeeingDialogFragment(
            title = getString(R.string.dialog_title, coffeeing.title),
            context = getString(R.string.dialog_submit_context),
            clickBtn = { }
        ).show(supportFragmentManager, DIALOG)
    }
}