package com.example.myproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.DecimalFormat

class ItemsAdapter(private val items: ArrayList<ItemsDomaine>) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private val formatter = DecimalFormat("##,##,##,##,##")
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.scroll_main, parent, false)
        context = parent.context
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]

        // Set data to your views here
        holder.addressTextView.text = currentItem.address
        //holder.descriptionTextView.text = currentItem.description
        holder.priceTextView.text = formatter.format(currentItem.price)
        holder.titleTextView.text = currentItem.titleTxt

        // val drawableResourceId = holder.itemView.resources.getIdentifier(currentItem.pic, "drawable", holder.itemView.context.packageName)
        //Glide.with(holder.itemView.context)
        // .load(drawableResourceId)
        //.into(holder.pic)

        //holder.itemView.setOnClickListener {
        //val intent = Intent(holder.itemView.context, MainActivity::class.java)
        // holder.itemView.context.startActivity(intent)
        //}
    }


    override fun getItemCount(): Int {
        return items.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val addressTextView: TextView = itemView.findViewById(R.id.adress)
        val priceTextView: TextView = itemView.findViewById(R.id.price)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTxt)

        //val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        //Initialize other views here
    }
}
