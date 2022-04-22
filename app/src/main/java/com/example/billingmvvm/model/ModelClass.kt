package com.example.billingmvvm.model

data class ModelClass(
    val data: Data
) {
    data class Data(
        val items: List<Item>
    ) {
        data class Item(
            val cName: String,
            val cType: String,
            val category: String,
            val cid: String,
            val data: String,
            val groupId: String,
            val gst: Int,
            val hsnCode: Double,
            val id: String,
            val inStock: Boolean,
            val mrp: Double,
            val name: String,
            val packaging: String,
            val ptr: Double,
            val qty: Int,
            val rack: String,
            val sortKey: String,
            val stock: String,
            val stockMrp: Int,
            val stockQty: Int,
            val table: String,
            val unitRatio: Int,
            val uom: String
        )
    }
}