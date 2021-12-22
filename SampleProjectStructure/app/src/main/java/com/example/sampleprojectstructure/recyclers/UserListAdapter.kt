package com.example.sampleprojectstructure.recyclers

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleprojectstructure.R
import com.example.sampleprojectstructure.databinding.UserListBinding
import com.example.sampleprojectstructure.model.UserEntity
const val TAG = "recyclerFix"

var i  = 0

class UserListAdapter(val context:Context,val list : MutableList<UserEntity>) : RecyclerView.Adapter<UserListAdapter.UserListAdapterViewHolder>() {

    class UserListAdapterViewHolder(val binding : UserListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapterViewHolder {
        
        //log for the recycler view
        i++
        Log.d(TAG, "onCreateViewHolder: $i-call")
       val binding = DataBindingUtil.inflate<UserListBinding>(
           LayoutInflater.from(context),
           R.layout.user_list,
           parent,
           false
       )

       return UserListAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListAdapterViewHolder, position: Int) {

        Log.d(TAG, "onBindViewHolder: called")
       holder.binding.textView.text = list[position].id.toString()
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ${list.size}")
        return list.size
    }

}