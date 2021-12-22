package com.sumit.userapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sumit.userapp.R
import com.sumit.userapp.database.model.User
import com.sumit.userapp.databinding.ItemListBinding

class UserListAdaptor (private val context: Context,
                       private val userList :ArrayList<User>) : RecyclerView.Adapter<UserListAdaptor.ViewHolder>() {
    class ViewHolder(val binding:ItemListBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val binding = DataBindingUtil.inflate<ItemListBinding>(
             LayoutInflater.from(context),
             R.layout.item_list,
             parent,
            false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.user = userList[position]
    }

    override fun getItemCount(): Int {
       return  userList.size
    }
}