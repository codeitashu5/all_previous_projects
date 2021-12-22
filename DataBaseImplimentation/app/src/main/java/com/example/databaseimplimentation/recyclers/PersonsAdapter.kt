package com.example.databaseimplimentation.recyclers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databaseimplimentation.R
import com.example.databaseimplimentation.databinding.PersonItemBinding

class PersonsAdapter(val context: Context,val list: MutableList<Any>) : RecyclerView.Adapter<PersonsAdapter.PersonAdapterViewHolder>() {

    class PersonAdapterViewHolder(val binding: PersonItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapterViewHolder {
        val binding = DataBindingUtil.inflate<PersonItemBinding>(
            LayoutInflater.from(context),
            R.layout.person_item,
            parent,
            false
        )

        return PersonAdapterViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PersonAdapterViewHolder, position: Int) {
        //here we will put the data we have created
        holder.binding.textName.text = list[position].toString()
    }

    override fun getItemCount(): Int {
       return list.size
    }
}