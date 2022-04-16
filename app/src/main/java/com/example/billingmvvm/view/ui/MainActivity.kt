package com.example.billingmvvm.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.billingmvvm.databinding.ActivityMainBinding
import com.example.billingmvvm.model.Data
import com.example.billingmvvm.repository.Repository
import com.example.billingmvvm.view.adapter.ContentAdapter
import com.example.billingmvvm.viewmodel.MainActivityViewModel
import com.example.billingmvvm.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var contentAdapter:ContentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        setUpRecyclerView()

        val repository=Repository()
        val viewModelFactory=MainActivityViewModelFactory(repository)
         viewModel=ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.getItem()
        viewModel.myResponse.observe(this, Observer{ response ->
            if (response.isSuccessful && response.body()?.data?.items != null){
                 Log.d("Response",response.raw().toString())
                 contentAdapter.ContentListItem=response.body()!!.data.items
                Toast.makeText(
                    this,
                    "hola",
                    Toast.LENGTH_SHORT
                ).show()

            }else{
                Log.d("Response",response.errorBody().toString())
            }
        })


         val myPost= Data.Items(21,132,"model")
        val myPost1= Data.Items(11,111,"LLLLL")
        viewModel.getItemList(myPost)
        viewModel.getItemList(myPost1)
        viewModel.myResponseItems.observe(this, Observer { response->
            if(response.isSuccessful && response.body() != null){
                Toast.makeText(this,response.code().toString(),Toast.LENGTH_SHORT).show()

                Log.d("Response",response.body().toString())
                Log.d("Response",response.body()?.name.toString())
                Log.d("Response",response.body()?.gst.toString())
                Log.d("Response",response.body()?.mrp.toString())
            }else{
                Log.d("Response",response.errorBody().toString())
            }

        })
    }

    private fun setUpRecyclerView()=binding.recyclerview.apply {
        contentAdapter=ContentAdapter()
        adapter=contentAdapter
        layoutManager=LinearLayoutManager(this@MainActivity)

    }
}