package com.example.billingmvvm.data

import com.example.billingmvvm.model.ModelClass
import com.example.billingmvvm.model.SearchPost
import com.example.billingmvvm.util.Constants.Companion.SESSION_TOKEN
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface InterfaceApi {
    @Headers(
        SESSION_TOKEN
    )
    @GET("temp_bill")
    suspend fun getItem(): Response<ModelClass>

    @Headers(
        SESSION_TOKEN
    )
    @POST("mobile_search_bill_item")
    suspend fun getItemList(
        @Body post: SearchPost
    ): Response<ModelClass>
}
