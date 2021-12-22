package com.sumit.userapp.dataBinding

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sumit.userapp.database.model.User
import com.sumit.userapp.ui.MainActivity
import com.sumit.userapp.ui.UserListAdaptor

@SuppressLint("SetTextI18n")
@BindingAdapter("bindName")
fun bindName(textView: TextView, string: String?) {
    textView.text = "-"
    if (string != null) {
        if (string.isNotEmpty()){
            textView.text = string.substring(0,1).uppercase()+string.substring(1)
        }

    }
}

@SuppressLint("NotifyDataSetChanged")
@BindingAdapter("bindUserList")
fun bindUserList(recyclerView: RecyclerView,liveDataUserList : LiveData<List<User>>){
    val userList = ArrayList<User>()
    liveDataUserList.observe(recyclerView.context as MainActivity){
        userList.clear()
        userList.addAll(it)
        if (recyclerView.layoutManager  == null){
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        }
        if (recyclerView.adapter == null){
            recyclerView.adapter = UserListAdaptor(recyclerView.context,userList)
        }else{
            recyclerView.adapter!!.notifyDataSetChanged()
        }
    }

}