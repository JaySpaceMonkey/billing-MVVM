package com.example.billingmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import com.example.billingmvvm.repository.Repository

class MainActivityViewModelFactory(
    private val repository: Repository
) : Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }

}