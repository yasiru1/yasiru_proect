package com.yasiru.inntavola.ui.items

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.yasiru.inntavola.data.entities.Item
import com.yasiru.inntavola.R
import com.yasiru.inntavola.databinding.ItemFoodBinding

class ItemsAdapter(private val listener: ItemListener) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    interface ItemListener {
        fun onClickedItem(itemId: Int)
    }

    private val items = ArrayList<Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: ArrayList<Item>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemFoodBinding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind(items[position])

    inner class ItemViewHolder(private val itemBinding: ItemFoodBinding, private val listener: ItemListener) :
        RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        private lateinit var user: Item

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: Item) {
            this.user = item
            itemBinding.listItemTitle.text = item.item_name
            itemBinding.listItemDescription.text = item.item_description
            itemBinding.listItemWeight.text = item.item_weight

            Glide.with(itemBinding.root.context)
                .load(item.item_image)
                .override(108, 108)
                .dontAnimate()
                .error(R.drawable.error)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(itemBinding.listItemImage)
        }

        override fun onClick(v: View?) {
            listener.onClickedItem(user.id!!)
        }
    }
}
