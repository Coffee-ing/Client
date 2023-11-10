package com.coffeeing.client.util.binding

import android.os.Bundle
import android.view.View
import com.coffeeing.client.R
import com.coffeeing.client.databinding.DialogCoffeeingBinding

class BindingCoffeeingDialogFragment(
    private val title: String,
    private val context: String,
    private val clickBtn: () -> Unit
) : BindingDialogFragment<DialogCoffeeingBinding>(R.layout.dialog_coffeeing) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        addListeners()
    }

    private fun initLayout() {
        with(binding) {
            tvDialogCoffeeingTitle.text = title
            tvDialogCoffeeingContext.text = context
        }
    }

    private fun addListeners() {
        binding.btnDialogCoffeeing.setOnClickListener {
            clickBtn.invoke()
            dismiss()
        }
    }
}