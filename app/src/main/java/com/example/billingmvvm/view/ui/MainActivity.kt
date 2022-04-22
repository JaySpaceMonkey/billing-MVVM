package com.example.billingmvvm.view.ui

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.billingmvvm.databinding.ActivityMainBinding
import com.example.billingmvvm.model.ModelClass
import com.example.billingmvvm.model.SearchPost
import com.example.billingmvvm.repository.Repository
import com.example.billingmvvm.view.adapter.ContentAdapter
import com.example.billingmvvm.viewmodel.MainActivityViewModel
import com.example.billingmvvm.viewmodel.MainActivityViewModelFactory
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var contentAdapter: ContentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val repository = Repository()
        val viewModelFactory = MainActivityViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)


        setUpRecyclerView()

        viewModel.searchStr =
            binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let { SearchPost(it) }?.let { viewModel.getItemList(it) }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText?.isNotEmpty() == true) {
                        newText.let {
                            SearchPost(it)
                        }.let {
                            viewModel.getItemList(it)
                        }

                    } else if (newText.isNullOrBlank()) {
                        val a = emptyList<ModelClass.Data.Item>()
                        contentAdapter.ContentListItem = a

                    }



                    return true

                }

            }).toString()




        viewModel.myResponseItems.observe(this, Observer { response ->
            if (response.isSuccessful && response.body() != null) {
                contentAdapter.ContentListItem = response.body()!!.data.items

            } else if(response.body()?.data?.items == null){

                Snackbar.make(binding.root,"NO ITEMS AT STORE",Snackbar.LENGTH_SHORT).show()
            }
            else{
                // if(response.code()=="401"){
                //refresh session token

                //}
                Log.d("Response", response.errorBody().toString())
            }

        })
//        viewModel.getItem()
//        viewModel.myResponse.observe(this, Observer { response ->
//            if (response.isSuccessful && response.body()?.data?.items != null) {
//                Log.d("Response", response.raw().toString())
//                contentAdapter.ContentListItem = response.body()!!.data.items
//
//
//            } else {
//                Log.d("Response", response.errorBody().toString())
//            }
//        })
    }

    private fun setUpRecyclerView() = binding.recyclerview.apply {
        contentAdapter = ContentAdapter()
        adapter = contentAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)

    }


}