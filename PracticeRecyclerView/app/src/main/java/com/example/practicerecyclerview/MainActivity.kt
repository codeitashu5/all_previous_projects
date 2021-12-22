package com.example.practicerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicerecyclerview.recycler.practice.CustomAdapter
import com.example.practicerecyclerview.recycler.practice.Item

class MainActivity : AppCompatActivity() {
    val mutableLiveData = MutableLiveData<ArrayList<Item>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
        //creating dummy data
        val list = ArrayList<Item>()
        for (i in 1..5) {
            val st1 = "top Name-$i"
            val st2 = "buttom Name-$i"

            val item = Item(st1, st2)
            list.add(item)
        }



        val btnRemove = findViewById<Button>(R.id.btnRemove)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        btnRemove.setOnClickListener {
            //mutableLiveData return reference of the list contained by it
            val newList = mutableLiveData.value!!
            newList?.let {
                if(it.size>0)
                it.removeAt(it.size-1)
                else{
                    Toast.makeText(this,"List is Empty",Toast.LENGTH_LONG).show()
                }
                mutableLiveData.value = it
            }


        }

        btnAdd.setOnClickListener {
            val st1 = "top Name-${list.size+1}"
            val st2 = "buttom Name-${list.size+1}"

            val item = Item(st1, st2)
            list.add(item)
            //assignment is required by both of them
            //returns the direct reference and changes are made in that
            mutableLiveData.value = list
        }

    }


    //observer can be put inside any function as we change the data liveData but the function
    //did not get called every single time
    private fun setRecyclerView() {

        Toast.makeText(this,"Function Get Called",Toast.LENGTH_LONG).show()
        //val list = ArrayList<Item>()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        mutableLiveData.observe(this,{ l ->
            //Toast.makeText(this,"observer Get Called",Toast.LENGTH_SHORT).show()
            //list.clear()
            //list.addAll(l)
            if (recyclerView.layoutManager == null) {
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
            if (recyclerView.adapter == null){
                recyclerView.adapter = CustomAdapter(l)
            }
            else {
                recyclerView.adapter!!.notifyDataSetChanged()
            }

        })

    }
}