package com.example.usingviewbindinginrecyclerandfragment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.usingviewbindinginrecyclerandfragment.R
import com.example.usingviewbindinginrecyclerandfragment.databinding.LayoutCommonBinding

class LocationListAdapter(val context:Context,val list : MutableList<Location>) : RecyclerView.Adapter<LocationListAdapter.ViewHolder>() {

    class ViewHolder(binding: LayoutCommonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : LayoutCommonBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_common,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
    }

}