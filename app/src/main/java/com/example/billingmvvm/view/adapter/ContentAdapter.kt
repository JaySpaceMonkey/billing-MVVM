package com.example.billingmvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.billingmvvm.databinding.CardInContentsBinding
import com.example.billingmvvm.model.RecyclerList

class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<RecyclerList.Items>() {
        override fun areItemsTheSame(
            oldItem: RecyclerList.Items,
            newItem: RecyclerList.Items
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RecyclerList.Items,
            newItem: RecyclerList.Items
        ): Boolean {

            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)
    var ContentListItem: List<RecyclerList.Items>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentAdapter.ContentViewHolder {

        return ContentViewHolder(
            binding = CardInContentsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContentAdapter.ContentViewHolder, position: Int) {
        holder.binding.apply {
            val itemList = ContentListItem[position]
            itemName.text = itemList.name
            itemMrp.text = itemList.mrp.toString()
            itemGst.text = itemList.gst.toString()
        }
    }

    override fun getItemCount(): Int {
        return ContentListItem.size
    }

    inner class ContentViewHolder(val binding: CardInContentsBinding) :
        RecyclerView.ViewHolder(binding.root)
}