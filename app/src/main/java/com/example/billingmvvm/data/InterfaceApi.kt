package com.example.billingmvvm.data

import com.example.billingmvvm.model.Data
import com.example.billingmvvm.model.RecyclerList
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface InterfaceApi {
    @GET("prod/temp_bill")
    suspend fun getItem(): Response<List<RecyclerList.Items>>
    @Headers(
        "session-token:user565d90f6-0e4b-11ec-9466-15093a597c0a"
    )
    @POST("prod/mobile_search_bill_item")
    suspend fun getItemList(
        @Body myPost:Data.Items
    ):Response<Data.Items>
}