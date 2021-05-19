package com.example.recycleapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleapplication.databinding.RecycleItemBinding


class RecycleViewAdapter(private val items: MutableList<TechnologyModel>,private val click:(TechnologyModel)->Unit) :
    RecyclerView.Adapter<RecycleViewAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            RecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(private val binding: RecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val model = items[adapterPosition]
            binding.imgTechnology.setImageResource(model.image)
            binding.tvTitle.text = model.title
            binding.tvDescription.text = model.description
            binding.root.setOnClickListener {
                click(model)
            }
        }
    }
}