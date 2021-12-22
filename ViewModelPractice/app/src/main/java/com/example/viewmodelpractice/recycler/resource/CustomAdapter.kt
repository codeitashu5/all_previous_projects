package com.example.viewmodelpractice.recycler.resource

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelpractice.R
import com.example.viewmodelpractice.databinding.LayoutRecyclerBinding

class CustomAdapter(val context: Context, val userList: MutableList<User>) : RecyclerView.Adapter<CustomAdapter.Holder>() {

    class Holder(val item: LayoutRecyclerBinding) : RecyclerView.ViewHolder(item.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val bindingUtil: LayoutRecyclerBinding = DataBindingUtil.inflate(
           LayoutInflater.from(context),
           R.layout.layout_recycler,
           parent,
           false)

       return  Holder(bindingUtil)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = userList[position]
        Log.d("listTest", "onBindViewHolder: id = ${data.id}   position = $position ")
        holder.item.name.text = userList[position].name + "${userList[position].id}"
    }

    override fun getItemCount(): Int {
       return userList.size
    }
}