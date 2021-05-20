package com.example.recycleapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleapplication.databinding.RecycleItemBinding
import com.example.recycleapplication.databinding.SecondRecyclerItemBinding


class RecycleViewAdapter(
    private val items: MutableList<TechnologyModel>,
    private val click: (TechnologyModel) -> Unit,
    private val longClick: (Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val WITH_IMAGE = 1
        private const val WITHOUT_IMAGE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            WITH_IMAGE -> {
                val itemView =
                    RecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                FirstViewHolder(itemView)
            }
            else -> {
                val itemView =
                    SecondRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SecondViewHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is FirstViewHolder -> holder.bind()
            is SecondViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = items.size

    inner class FirstViewHolder(private val binding: RecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val model = items[adapterPosition]
            binding.imgTechnology.setImageResource(model.image as Int)
            binding.tvTitle.text = model.title
            binding.tvDescription.text = model.description
            binding.root.setOnClickListener {
                click(model)
            }
            binding.root.setOnLongClickListener {
                longClick(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    inner class SecondViewHolder(private val binding: SecondRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val model = items[adapterPosition]
            binding.tvTitle.text = model.title
            binding.tvDescription.text = model.description
            binding.root.setOnClickListener {
                click(model)
            }
            binding.root.setOnLongClickListener {
                longClick(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].image) {
            null -> WITHOUT_IMAGE
            else -> WITH_IMAGE
        }
    }
}