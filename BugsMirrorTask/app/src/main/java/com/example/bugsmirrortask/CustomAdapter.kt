package com.example.bugsmirrortask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bugsmirrortask.fragments.FragmentList

class CustomAdapter(val list: MutableList<String>, val o: ItemClickedListener):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
           itemView.setOnClickListener {
               o.onItemClicked(adapterPosition,list[adapterPosition])
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_layout,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = holder.itemView.findViewById<TextView>(R.id.app_name)
        name.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
interface ItemClickedListener{
    fun onItemClicked(pos:Int,text:String)
}
