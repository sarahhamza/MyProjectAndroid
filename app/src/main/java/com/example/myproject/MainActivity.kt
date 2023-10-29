package com.example.myproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewPopular: RecyclerView
    private lateinit var itemsAdapterPopular: ItemsAdapter
    private val itemsListPopular: ArrayList<ItemsDomaine> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scroll_main)

        // Initialisation du RecyclerView et ajout des éléments à la liste itemsListPopular
        recyclerViewPopular = findViewById(R.id.viewPopular)

        // Ajout d'exemples d'éléments à la liste itemsListPopular
        val item1 = ItemsDomaine("Dar Calibori", "Sousse", 100, "pic1")
        val item2 = ItemsDomaine("Plermio", "Sud", 200, "pic2")
        itemsListPopular.add(item1)
        itemsListPopular.add(item2)

        // Configuration du RecyclerView avec un LayoutManager et l'adaptateur
        itemsAdapterPopular = ItemsAdapter(itemsListPopular)
        recyclerViewPopular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPopular.adapter = itemsAdapterPopular

    }
}

