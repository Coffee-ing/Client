package com.coffeeing.client.presentation.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coffeeing.client.databinding.ItemDetailButtonBinding


class DetailButtonAdapter(context: Context) : RecyclerView.Adapter<DetailButtonViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    private var detailButtonList: List<DetailButton> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailButtonViewHolder {
        val binding = ItemDetailButtonBinding.inflate(inflater, parent, false)
        return DetailButtonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailButtonViewHolder, position: Int) {
        holder.onBind(detailButtonList[position])
    }

    override fun getItemCount() = detailButtonList.size

    fun setFriendList(friendList: List<DetailButton>) {
        this.detailButtonList = friendList.toList()
        notifyDataSetChanged()
    }
}