package com.example.billingmvvm.model

data class Data(
    val items:Items
)
{
    data class Items(
        val gst:Int,
        val mrp:Int,
        val name:String,

    )
}