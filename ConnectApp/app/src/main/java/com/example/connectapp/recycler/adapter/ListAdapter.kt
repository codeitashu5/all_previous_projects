package com.example.connectapp.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.connectapp.R
import com.example.connectapp.databinding.FragmentRegesterBinding
import com.example.connectapp.databinding.RecyclerListBinding
import com.example.connectapp.model.UserDataResponseItem

private lateinit var binding: RecyclerListBinding
class ListAdapter(val context: Context,val list: MutableList<UserDataResponseItem>) : RecyclerView.Adapter<ListAdapter.ViewHolderListAdapter>() {

    class ViewHolderListAdapter(binding: RecyclerListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderListAdapter {
       binding = DataBindingUtil.inflate(
           LayoutInflater.from(context),
           R.layout.recycler_list,
           parent,
           false
       )

        return ViewHolderListAdapter(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderListAdapter, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}