package com.example.myproject

import java.io.Serializable

class ItemsDomaine(
    val titleTxt: String,
    val address: String,
    val price: Int,
    val pic: String
) : Serializable {
}