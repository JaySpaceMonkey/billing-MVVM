package com.example.billingmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.billingmvvm.model.Data
import com.example.billingmvvm.model.RecyclerList
import com.example.billingmvvm.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivityViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<List<RecyclerList.Items>>> = MutableLiveData()
    val myResponseItems:MutableLiveData<Response<Data.Items>> = MutableLiveData()
    fun getItem() {
        viewModelScope.launch {
            val response = repository.getItem()
            myResponse.value=response

        }
    }

    fun getItemList(myPost: Data.Items) {
        viewModelScope.launch {
            val response = repository.getItemList(myPost)
            myResponseItems.value=response


        }
    }

}