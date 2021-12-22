package com.example.viewmodelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelpractice.databinding.ActivityMainBinding
import com.example.viewmodelpractice.recycler.resource.CustomAdapter
import com.example.viewmodelpractice.recycler.resource.User
import com.example.viewmodelpractice.view.model.Model

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private val model : Model by viewModels()
    private lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recycler = binding.recyclerView

        //add dummy data
        val mutableList = mutableListOf<User>()
        for(i in 1..20){
            val user = User(i,"name")
            //it will not work as we get an object of that type
            mutableList.add(user)

        }

        for(i in mutableList){
            Log.d("test","${i.id}")
        }


        model.userMutableList.value = mutableList
        setAdapter()
        //set the initial value for the list

    }

    private fun setAdapter(){

        model.userMutableList.observe(this,{
            //update the recycler according to it
            val userList = mutableListOf<User>()
            userList.clear()
            userList.addAll(it)

            if(recycler.layoutManager == null){
                recycler.layoutManager = LinearLayoutManager(this)
            }
            if(recycler.adapter == null){
                recycler.adapter = CustomAdapter(this,userList)
            }
            else{
                recycler.adapter!!.notifyDataSetChanged()
            }
        })
    }
}