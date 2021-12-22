package com.example.navigation.recycler.resources

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.R
import com.example.navigation.databinding.RecyclerLayoutBinding

class ItemListAdapter(val context:Context,val mutableList: MutableList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var binding : RecyclerLayoutBinding? = null
    class ViewHolder(binding: RecyclerLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val binding : RecyclerLayoutBinding = DataBindingUtil.inflate<RecyclerLayoutBinding>(
           LayoutInflater.from(context),
           R.layout.recycler_layout,
           parent,
           false
       )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       binding?.text1?.text = mutableList[position].head1
        binding?.text2?.text = mutableList[position].head2
        binding?.text3?.text = mutableList[position].content
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }
}