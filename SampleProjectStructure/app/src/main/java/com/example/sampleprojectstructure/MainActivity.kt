package com.example.sampleprojectstructure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleprojectstructure.databinding.ActivityMainBinding
import com.example.sampleprojectstructure.model.UserEntity
import com.example.sampleprojectstructure.recyclers.UserListAdapter
import com.example.sampleprojectstructure.viewModels.ActivityViewModel
const val TAG = "MainTag"
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding : ActivityMainBinding
    private lateinit var list: MutableList<UserEntity>

    val viewModel : ActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recycler



        //get the value from the
        list = mutableListOf()
        setAdapter()

    }


fun setAdapter(){

    viewModel.getUserList(application).observe(this,{
        list.clear()
        list.addAll(it)
        if(recyclerView.layoutManager == null){
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
        if(recyclerView.adapter == null){
            recyclerView.adapter = UserListAdapter(this,list)
        }
        else{
            recyclerView.scrollToPosition(list.size-1)
            recyclerView.adapter!!.notifyDataSetChanged()
        }
    })
}
}