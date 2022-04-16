package com.example.billingmvvm.model

data class SearchResponse(
    val `data`: Data
) {
    data class Data(
        val items: List<Item>
    ) {
        data class Item(
            val cName: String,
            val cType: String,
            val category: String,
            val cid: String,
            val `data`: String,
            val groupId: String,
            val gst: Int,
            val hsnCode: Int,
            val id: String,
            val imageUrl: String,
            val inStock: Boolean,
            val manufacturer: String,
            val mrp: Int,
            val name: String,
            val packaging: String,
            val ptr: Double,
            val qty: Int,
            val rack: String,
            val sortKey: String,
            val stock: String,
            val stockMrp: Int,
            val stockQty: Int,
            val subCategory: String,
            val table: String,
            val unitRatio: Int,
            val uom: String
        )
    }
}