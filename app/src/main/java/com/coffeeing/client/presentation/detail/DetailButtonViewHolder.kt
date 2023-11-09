package com.coffeeing.client.presentation.detail


import androidx.recyclerview.widget.RecyclerView
import com.coffeeing.client.databinding.ItemDetailButtonBinding

class DetailButtonViewHolder(private val binding: ItemDetailButtonBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(detailButtonData: DetailButton) {
        binding.toggle1.text= detailButtonData.button_name
    }
}