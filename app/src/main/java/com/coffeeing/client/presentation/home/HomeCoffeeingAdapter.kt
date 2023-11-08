package com.coffeeing.client.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ItemHomeCoffeeingBinding
import com.coffeeing.client.domain.model.Coffeeing
import com.coffeeing.client.util.ItemDiffCallback

class HomeCoffeeingAdapter : ListAdapter<Coffeeing, HomeCoffeeingAdapter.HomeCoffeeingViewHolder>(
    ItemDiffCallback<Coffeeing>(
        onItemsTheSame = { old, new -> old.coffeeingId == new.coffeeingId },
        onContentsTheSame = { old, new -> old == new }
    )
) {
    class HomeCoffeeingViewHolder(
        private val binding: ItemHomeCoffeeingBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(coffeeing: Coffeeing) {
            with(binding) {
                if (coffeeing.isBaristaOriginal) chipItemHomeCoffeeingBaristaOriginal.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingBaristaOriginal.visibility = View.GONE
                if (coffeeing.isLocalArea) chipItemHomeCoffeeingLocalArea.visibility = View.VISIBLE
                else chipItemHomeCoffeeingLocalArea.visibility = View.GONE
                if (coffeeing.isHotPlace) chipItemHomeCoffeeingHotPlace.visibility = View.VISIBLE
                else chipItemHomeCoffeeingHotPlace.visibility = View.GONE
                if (coffeeing.isProfessional) chipItemHomeCoffeeingProfessional.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingProfessional.visibility = View.GONE
                if (coffeeing.isBiginner) chipItemHomeCoffeeingBeginner.visibility = View.VISIBLE
                else chipItemHomeCoffeeingBeginner.visibility = View.GONE

                ivItemHomeCoffeeing.load(coffeeing.coffeeingImg)
                tvItemHomeCoffeeingTitle.text = coffeeing.title
                tvItemHomeCoffeeingLocation.text = coffeeing.location
                tvItemHomeCoffeeingTime.text = coffeeing.time
                tvItemHomeCoffeeingPerson.text =
                    context.getString(R.string.home_coffeeing_person, coffeeing.person)

                tvItemHomeCoffeeingHeart.text = coffeeing.heartCount.toString()

                if (coffeeing.isHearted) ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_fill_heart)
                else ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_stroke_heart)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCoffeeingViewHolder {
        val binding =
            ItemHomeCoffeeingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeCoffeeingViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: HomeCoffeeingViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}