package com.example.myproject

import android.content.Intent
import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val myDataSet: ArrayList<String>,
    private val imageResources: ArrayList<Int>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>()
{

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                ViewHolder {
            val vh = LayoutInflater.from(parent.context).inflate(
                R.layout.itemslistview,
                parent, false
            )
            return ViewHolder(vh)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            var current = myDataSet[position]
            holder.vText.text = current.toString()
            holder.vImage.setImageResource(imageResources[position])
        }

        override fun getItemCount(): Int {
            return myDataSet.size
        }


       inner class ViewHolder(val itemview: View) :
            RecyclerView.ViewHolder(itemview),View.OnClickListener {
           val addressTextView: TextView = itemView.findViewById(R.id.adress)
           val priceTextView: TextView = itemView.findViewById(R.id.price)
           val titleTextView: TextView = itemView.findViewById(R.id.titleTxt)
           val vImage: ImageView = itemView.findViewById(R.id.imageView)
           init {
               itemView.setOnClickListener(this)
           }
           override fun onClick(v: View?) {
               val position = adapterPosition
               if (position != RecyclerView.NO_POSITION) {
                   val countryName = myDataSet[position]
                   val countryPhoto = imageResources[position]

                   val intent = Intent(itemView.context, DetailActivity::class.java)
                   intent.putExtra("countryName", countryName)
                   intent.putExtra("countryPhoto", countryPhoto)
                   itemView.context.startActivity(intent)
               }
           }
        }

    interface OnItemClickListener {
        fun onItemClick(position: Int){

        }
    }

    }



