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
import com.coffeeing.client.domain.model.MyLike
import com.coffeeing.client.util.ItemDiffCallback

class MypageCoffeeingLikeAdapter(
    private val moveToDetail: (Int) -> Unit
) : ListAdapter<MyLike, MypageCoffeeingLikeAdapter.MypageCoffeeingLikeViewHolder>(
    ItemDiffCallback<MyLike>(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new }
    )
) {
    class MypageCoffeeingLikeViewHolder(
        private val binding: ItemMypageCoffeeingBinding,
        private val context: Context,
        private val moveToDetail: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(myLike: MyLike) {
            with(binding) {

                if (myLike.tag == "original") chipItemHomeCoffeeingBaristaOriginal.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingBaristaOriginal.visibility = View.GONE
                if (myLike.tag == "friend") chipItemHomeCoffeeingLocalArea.visibility = View.VISIBLE
                else chipItemHomeCoffeeingLocalArea.visibility = View.GONE
                if (myLike.tag == "tour") chipItemHomeCoffeeingHotPlace.visibility = View.VISIBLE
                else chipItemHomeCoffeeingHotPlace.visibility = View.GONE
                if (myLike.tag == "worker") chipItemHomeCoffeeingProfessional.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingProfessional.visibility = View.GONE
                if (myLike.tag == "beginner") chipItemHomeCoffeeingBeginner.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingBeginner.visibility = View.GONE

                ivItemHomeCoffeeing.load(myLike.image)
                tvItemHomeCoffeeingTitle.text = myLike.title
                tvItemHomeCoffeeingLocation.text = myLike.district
                tvItemHomeCoffeeingTime.text = myLike.meet_time
                tvItemHomeCoffeeingPerson.text =
                    context.getString(R.string.home_coffeeing_person, myLike.num_people)

                tvItemHomeCoffeeingHeart.text = myLike.like.toString()

                if (myLike.iflike) ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_fill_heart)
                else ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_stroke_heart)

                root.setOnClickListener {
                    moveToDetail(myLike.id)
                }
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MypageCoffeeingLikeViewHolder {
        val binding =
            ItemMypageCoffeeingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MypageCoffeeingLikeAdapter.MypageCoffeeingLikeViewHolder(
            binding,
            parent.context,
            moveToDetail
        )
    }

    override fun onBindViewHolder(holder: MypageCoffeeingLikeViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}