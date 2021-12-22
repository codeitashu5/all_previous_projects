package com.example.networkcall.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.networkcall.R
import com.example.networkcall.databinding.RecyclerLayoutBinding
import com.example.networkcall.model.ResponseObjectItem

class RecyclerListAdapter(val context: Context, val arrayList: ArrayList<ResponseObjectItem>) : RecyclerView.Adapter<RecyclerListAdapter.ViewHolderListAdapter>() {


    class ViewHolderListAdapter( val binding: RecyclerLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderListAdapter {
        //always crate an new object for the viewModel object
         val binding = DataBindingUtil.inflate<RecyclerLayoutBinding>(
            LayoutInflater.from(context),
            R.layout.recycler_layout,
            parent,
            false
        )
        return ViewHolderListAdapter(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderListAdapter, position: Int) {
        holder.binding.text3.text = "${position+1}."
        holder.binding.text1.text = "Name :- ${arrayList[position].name}"
        holder.binding.text2.text = "Email :- ${arrayList[position].email}"
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}