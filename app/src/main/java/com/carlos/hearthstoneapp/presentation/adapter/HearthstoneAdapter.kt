package com.carlos.hearthstoneapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carlos.hearthstoneapp.R
import com.carlos.hearthstoneapp.presentation.model.CardViewObject

class HearthstoneAdapter(
    private val hearthstoneCards: List<CardViewObject>,
    private val onItemClickListener: ((events: CardViewObject) -> Unit)
) : RecyclerView.Adapter<HearthstoneAdapter.HearthstoneViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HearthstoneAdapter.HearthstoneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_list, parent, false)

        return HearthstoneViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(
        holder: HearthstoneAdapter.HearthstoneViewHolder, position: Int
    ) {
        val hearthstoneClass = hearthstoneCards[position]

        holder.apply {
            className.text = hearthstoneClass.name

            itemView.setOnClickListener {
                onItemClickListener.invoke(hearthstoneClass)
            }

            Glide.with(itemView)
                .load(hearthstoneClass.img)
                .placeholder(R.drawable.hearthstone_logo)
                .into(cardImage)
        }
    }

    override fun getItemCount() = hearthstoneCards.size

    inner class HearthstoneViewHolder(
        itemView: View, private val onItemClickListener: ((events: CardViewObject) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        val className: TextView = itemView.findViewById(R.id.txt_card_name)
        val cardImage: ImageView = itemView.findViewById(R.id.img_card_logo)
    }
}
