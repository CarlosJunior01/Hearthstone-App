package com.carlos.hearthstoneapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carlos.hearthstoneapp.R
import com.carlos.hearthstoneapp.presentation.model.HearthstoneClassVO

class HearthstoneHomeAdapter(
    private val hearthstoneClasses: List<HearthstoneClassVO>,
    private val onItemClickListener: ((events: HearthstoneClassVO) -> Unit)
) : RecyclerView.Adapter<HearthstoneHomeAdapter.HearthstoneViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HearthstoneHomeAdapter.HearthstoneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_menu_list, parent, false)

        return HearthstoneViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(
        holder: HearthstoneHomeAdapter.HearthstoneViewHolder, position: Int
    ) {
        val hearthstoneClass = hearthstoneClasses[position]

        holder.apply {
            className.text = hearthstoneClass.name

            itemView.setOnClickListener {
                onItemClickListener.invoke(hearthstoneClass)
            }
        }
    }

    override fun getItemCount() = hearthstoneClasses.size

    inner class HearthstoneViewHolder(
        itemView: View, private val onItemClickListener: ((events: HearthstoneClassVO) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {
        val className: TextView = itemView.findViewById(R.id.txt_class_name)
    }
}