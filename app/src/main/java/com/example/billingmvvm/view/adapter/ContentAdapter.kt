package com.example.billingmvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.billingmvvm.databinding.CardInContentsBinding
import com.example.billingmvvm.model.ModelClass

class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<ModelClass.Data.Item>() {
        override fun areItemsTheSame(
            oldItem: ModelClass.Data.Item,
            newItem: ModelClass.Data.Item
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ModelClass.Data.Item,
            newItem: ModelClass.Data.Item
        ): Boolean {

            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)
    var ContentListItem: List<ModelClass.Data.Item>
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