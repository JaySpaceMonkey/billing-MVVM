package com.example.billingmvvm.repository

import com.example.billingmvvm.data.RetrofitInstance
import com.example.billingmvvm.model.Data
import com.example.billingmvvm.model.RecyclerList
import retrofit2.Response

class Repository {
    suspend fun getItem(): Response<List<RecyclerList.Items>> {
        return RetrofitInstance.api.getItem()
    }

    suspend fun getItemList(myPost:Data.Items): Response<Data.Items> {
        return RetrofitInstance.api.getItemList(myPost)
    }
}