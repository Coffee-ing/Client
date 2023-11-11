package com.coffeeing.client.presentation.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ItemMypageCoffeeingBinding
import com.coffeeing.client.domain.model.MyApply
import com.coffeeing.client.util.ItemDiffCallback

class MypageCoffeeingApplyAdapter(
    private val moveToDetail: (Int) -> Unit
) : ListAdapter<MyApply, MypageCoffeeingApplyAdapter.MypageCoffeeingApplyViewHolder>(
    ItemDiffCallback<MyApply>(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new }
    )
) {
    class MypageCoffeeingApplyViewHolder(
        private val binding: ItemMypageCoffeeingBinding,
        private val context: Context,
        private val moveToDetail: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(myApply: MyApply) {
            with(binding) {

                if (myApply.tag == "original") chipItemHomeCoffeeingBaristaOriginal.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingBaristaOriginal.visibility = View.GONE
                if (myApply.tag == "friend") chipItemHomeCoffeeingLocalArea.visibility = View.VISIBLE
                else chipItemHomeCoffeeingLocalArea.visibility = View.GONE
                if (myApply.tag == "tour") chipItemHomeCoffeeingHotPlace.visibility = View.VISIBLE
                else chipItemHomeCoffeeingHotPlace.visibility = View.GONE
                if (myApply.tag == "worker") chipItemHomeCoffeeingProfessional.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingProfessional.visibility = View.GONE
                if (myApply.tag == "beginner") chipItemHomeCoffeeingBeginner.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingBeginner.visibility = View.GONE

                ivItemHomeCoffeeing.load(myApply.image)
                tvItemHomeCoffeeingTitle.text = myApply.title
                tvItemHomeCoffeeingLocation.text = myApply.district
                tvItemHomeCoffeeingTime.text = myApply.meet_time
                tvItemHomeCoffeeingPerson.text =
                    context.getString(R.string.home_coffeeing_person, myApply.num_people)

                tvItemHomeCoffeeingHeart.text = myApply.like.toString()

                if (myApply.iflike) ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_fill_heart)
                else ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_stroke_heart)

                root.setOnClickListener {
                    moveToDetail(myApply.id)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MypageCoffeeingApplyAdapter.MypageCoffeeingApplyViewHolder {
        val binding =
            ItemMypageCoffeeingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MypageCoffeeingApplyAdapter.MypageCoffeeingApplyViewHolder(
            binding,
            parent.context,
            moveToDetail
        )
    }

    override fun onBindViewHolder(holder: MypageCoffeeingApplyAdapter.MypageCoffeeingApplyViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}