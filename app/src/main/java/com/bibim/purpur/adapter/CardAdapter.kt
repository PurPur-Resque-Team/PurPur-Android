package com.bibim.purpur.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bibim.purpur.data.model.Mission
import com.bibim.purpur.databinding.ItemCardBinding
import com.bibim.purpur.onlyOneClickListener

class CardAdapter(private val clickListener: CardViewHolder.MissionItemClickListener) :
    RecyclerView.Adapter<CardViewHolder>() {
    private val cardData = ArrayList<Int>()
    private val isClearedData = ArrayList<Mission>()

    fun setCardItemList(newData: List<Int>) {
        with(cardData) {
            clear()
            addAll(newData)
        }
        notifyDataSetChanged()
    }

    fun setIsClearedList(newData: List<Mission>) {
        with(isClearedData) {
            clear()
            addAll(newData)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding, clickListener, isClearedData)
    }

    override fun getItemCount(): Int {
        return cardData.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardData[position])
    }
}

class CardViewHolder(
    private val binding: ItemCardBinding,
    private val clickListener: MissionItemClickListener,
    private val isCleared: ArrayList<Mission>
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.itemIvCard.onlyOneClickListener {
            clickListener.missionItemClick(absoluteAdapterPosition, isCleared)
        }
    }

    interface MissionItemClickListener {
        fun missionItemClick(position: Int, isCleared: ArrayList<Mission>)
    }

    fun bind(drawable: Int) {
        binding.itemIvCard.setImageResource(drawable)

    }
}
