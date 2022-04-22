package com.example.billingmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.billingmvvm.model.ModelClass
import com.example.billingmvvm.model.SearchPost
import com.example.billingmvvm.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivityViewModel(private val repository: Repository) : ViewModel() {
    var searchStr: String = ""

    val myResponse: MutableLiveData<Response<ModelClass>> = MutableLiveData()
    val myResponseItems: MutableLiveData<Response<ModelClass>> = MutableLiveData()
    fun getItem() {
        viewModelScope.launch {
            val response = repository.getItem()
            myResponse.value = response

        }
    }

    fun getItemList(myPost: SearchPost) {
        viewModelScope.launch {
            val response = repository.getItemList(myPost)
            myResponseItems.value = response


        }
    }

}