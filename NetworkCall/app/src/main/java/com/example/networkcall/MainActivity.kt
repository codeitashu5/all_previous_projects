package com.example.networkcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkcall.databinding.ActivityMainBinding
import com.example.networkcall.model.ResponseObjectItem
import com.example.networkcall.recycler.adapter.RecyclerListAdapter
import com.example.networkcall.viewModel.ViewModelMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView : RecyclerView
    private val viewModel : ViewModelMain by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView = binding.recyclerView

        viewModel.getData()
        setRecyclerView()

    }

    private fun setRecyclerView() {
        val arrayList : ArrayList<ResponseObjectItem> = arrayListOf()
          viewModel.listUser.observe(this,{
          arrayList.clear()
          arrayList.addAll(it)

          if(recyclerView.layoutManager == null){
              recyclerView.layoutManager = LinearLayoutManager(this)
          }

          if(recyclerView.adapter == null){
              recyclerView.adapter = RecyclerListAdapter(this,arrayList)
          }
          else{
              recyclerView.adapter!!.notifyDataSetChanged()
          }

      })
    }
}