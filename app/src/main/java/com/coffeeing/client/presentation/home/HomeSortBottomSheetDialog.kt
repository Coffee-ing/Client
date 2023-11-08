package com.coffeeing.client.presentation.home

import android.os.Bundle
import android.view.View
import com.coffeeing.client.R
import com.coffeeing.client.databinding.DialogBottomHomeSortBinding
import com.coffeeing.client.presentation.type.HomeSortType
import com.coffeeing.client.util.binding.BindingBottomSheetDialogFragment

class HomeSortBottomSheetDialog(
    private val currentSortType: HomeSortType,
    private val sort: (HomeSortType) -> Unit
) : BindingBottomSheetDialogFragment<DialogBottomHomeSortBinding>(R.layout.dialog_bottom_home_sort) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        addListeners()
    }

    private fun initLayout() {
        with(binding) {
            tvHomeSortDeadline.isSelected = currentSortType == HomeSortType.RECENT
            tvHomeSortPopularity.isSelected = currentSortType == HomeSortType.POPULARITY
            tvHomeSortDeadline.isSelected = currentSortType == HomeSortType.DEADLINE

            if (currentSortType == HomeSortType.RECENT) ivHomeSortRecent.visibility = View.VISIBLE
            else ivHomeSortRecent.visibility = View.INVISIBLE
            if (currentSortType == HomeSortType.POPULARITY) ivHomeSortPopularity.visibility =
                View.VISIBLE
            else ivHomeSortPopularity.visibility = View.INVISIBLE
            if (currentSortType == HomeSortType.DEADLINE) ivHomeSortDeadline.visibility =
                View.VISIBLE
            else ivHomeSortDeadline.visibility = View.INVISIBLE
        }
    }

    private fun addListeners() {
        binding.layoutHomeSortRecent.setOnClickListener {
            sort(HomeSortType.RECENT)
            dismiss()
        }

        binding.layoutHomeSortPopularity.setOnClickListener {
            sort(HomeSortType.POPULARITY)
            dismiss()
        }

        binding.layoutHomeSortDeadline.setOnClickListener {
            sort(HomeSortType.DEADLINE)
            dismiss()
        }
    }
}