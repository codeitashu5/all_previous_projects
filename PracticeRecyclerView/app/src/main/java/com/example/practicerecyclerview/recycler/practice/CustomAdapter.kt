package com.example.practicerecyclerview.recycler.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicerecyclerview.R

class CustomAdapter(private val list : MutableList<Item>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            //to be made
        R.layout.recycler_layout,
            parent,
            false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textTop = holder.itemView.findViewById<TextView>(R.id.textTop)
        val textButtom = holder.itemView.findViewById<TextView>(R.id.textButtom)

        textTop.text = list[position].topName
        textButtom.text = list[position].buttomName
    }

    override fun getItemCount(): Int {
        return list.size
    }
}