package com.example.myproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.DecimalFormat

class ItemsAdapter(private val items: ArrayList<ItemsDomaine>) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private val formatter = DecimalFormat("##,##,##,##,##")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.itemslistview, parent, false)
        return ViewHolder(inflate)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]

        // Set data to your views here
        holder.addressTextView.text = currentItem.address
        holder.priceTextView.text = formatter.format(currentItem.price)
        holder.titleTextView.text = currentItem.titleTxt
        val drawableResourceId = holder.itemView.resources.getIdentifier(currentItem.pic, "drawable", holder.itemView.context.packageName)
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.pic)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val addressTextView: TextView = itemView.findViewById(R.id.adress)
        val priceTextView: TextView = itemView.findViewById(R.id.price)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTxt)
        val pic: ImageView= itemView.findViewById(R.id.pic1)
    }
}
