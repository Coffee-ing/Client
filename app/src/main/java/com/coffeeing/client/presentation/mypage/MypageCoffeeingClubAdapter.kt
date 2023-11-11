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
import com.coffeeing.client.domain.model.MyClub
import com.coffeeing.client.util.ItemDiffCallback

class MypageCoffeeingClubAdapter(
    private val moveToDetail: (Int) -> Unit
) : ListAdapter<MyClub, MypageCoffeeingClubAdapter.MypageCoffeeingClubViewHolder>(
    ItemDiffCallback<MyClub>(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new }
    )
) {
    class MypageCoffeeingClubViewHolder(
        private val binding: ItemMypageCoffeeingBinding,
        private val context: Context,
        private val moveToDetail: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(myClub: MyClub) {
            with(binding) {

                if (myClub.tag == "original") chipItemHomeCoffeeingBaristaOriginal.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingBaristaOriginal.visibility = View.GONE
                if (myClub.tag == "friend") chipItemHomeCoffeeingLocalArea.visibility = View.VISIBLE
                else chipItemHomeCoffeeingLocalArea.visibility = View.GONE
                if (myClub.tag == "tour") chipItemHomeCoffeeingHotPlace.visibility = View.VISIBLE
                else chipItemHomeCoffeeingHotPlace.visibility = View.GONE
                if (myClub.tag == "worker") chipItemHomeCoffeeingProfessional.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingProfessional.visibility = View.GONE
                if (myClub.tag == "beginner") chipItemHomeCoffeeingBeginner.visibility =
                    View.VISIBLE
                else chipItemHomeCoffeeingBeginner.visibility = View.GONE

                ivItemHomeCoffeeing.load(myClub.image)
                tvItemHomeCoffeeingTitle.text = myClub.title
                tvItemHomeCoffeeingLocation.text = myClub.district
                tvItemHomeCoffeeingTime.text = myClub.meet_time
                tvItemHomeCoffeeingPerson.text =
                    context.getString(R.string.home_coffeeing_person, myClub.num_people)

                tvItemHomeCoffeeingHeart.text = myClub.like.toString()

                if (myClub.iflike) ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_fill_heart)
                else ivItemHomeCoffeeingHeart.setImageResource(R.drawable.ic_home_stroke_heart)

                root.setOnClickListener {
                    moveToDetail(myClub.id)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MypageCoffeeingClubViewHolder {
        val binding =
            ItemMypageCoffeeingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MypageCoffeeingClubAdapter.MypageCoffeeingClubViewHolder(
            binding,
            parent.context,
            moveToDetail
        )
    }

    override fun onBindViewHolder(holder: MypageCoffeeingClubViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}