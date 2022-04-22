package com.example.billingmvvm.repository

import com.example.billingmvvm.data.RetrofitInstance
import com.example.billingmvvm.model.ModelClass
import com.example.billingmvvm.model.SearchPost
import retrofit2.Response

class Repository {


    suspend fun getItem(): Response<ModelClass> {
        return RetrofitInstance.api.getItem()
    }

    suspend fun getItemList(myPost: SearchPost): Response<ModelClass> {
        return RetrofitInstance.api.getItemList(myPost)
    }
}