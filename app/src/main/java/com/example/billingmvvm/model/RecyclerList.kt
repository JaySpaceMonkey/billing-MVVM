package com.example.billingmvvm.model

data class RecyclerList(
    var items: Items
) {
    data class Items(
        val name: String,
        val mrp:Double,
        val gst: Double,
        val discount: Int,
        val itemAmount: Int,
        val id: String,
        val billQty: Int,
        val netItemAmount: Double
    )
}