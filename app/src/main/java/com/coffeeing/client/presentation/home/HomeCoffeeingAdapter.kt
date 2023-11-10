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
import com.coffeeing.client.domain.model.HomeCoffeeing
import com.coffeeing.client.util.ItemDiffCallback

class HomeCoffeeingAdapter(
    private val moveToDetail: (Int) -> Unit
) : ListAdapter<HomeCoffeeing, HomeCoffeeingAdapter.HomeCoffeeingViewHolder>(
    ItemDiffCallback<HomeCoffeeing>(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new }
    )
) {
    class HomeCoffeeingViewHolder(
        private val binding: ItemHomeCoffeeingBinding,
        private val context: Context,
        private val moveToDetail: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(home: HomeCoffeeing) {
            with(binding) {
                if (home.tag == "original") chipItemHomeCoffeeingBaristaOriginal.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingBaristaOriginal.visibility = View.GONE
                if (home.tag == "friend") chipItemHomeCoffeeingLocalArea.visibility = View.VISIBLE
                else chipItemHomeCoffeeingLocalArea.visibility = View.GONE
                if (home.tag == "tour") chipItemHomeCoffeeingHotPlace.visibility = View.VISIBLE
                else chipItemHomeCoffeeingHotPlace.visibility = View.GONE
                if (home.tag == "worker") chipItemHomeCoffeeingProfessional.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingProfessional.visibility = View.GONE
                if (home.tag == "beginner") chipItemHomeCoffeeingBeginner.visibility = View.VISIBLE
                else chipItemHomeCoffeeingBeginner.visibility = View.GONE

                ivItemHomeCoffeeing.load(home.image)
                tvItemHomeCoffeeingTitle.text = home.title
                tvItemHomeCoffeeingLocation.text = home.district
                tvItemHomeCoffeeingTime.text = home.meetTime
                tvItemHomeCoffeeingPerson.text =
                    context.getString(R.string.home_coffeeing_person, home.numPeople)

                tvItemHomeCoffeeingHeart.text = home.like.toString()

                if (home.iflike) ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_fill_heart)
                else ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_stroke_heart)

                root.setOnClickListener {
                    moveToDetail(home.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCoffeeingViewHolder {
        val binding =
            ItemHomeCoffeeingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeCoffeeingViewHolder(binding, parent.context, moveToDetail)
    }

    override fun onBindViewHolder(holder: HomeCoffeeingViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}