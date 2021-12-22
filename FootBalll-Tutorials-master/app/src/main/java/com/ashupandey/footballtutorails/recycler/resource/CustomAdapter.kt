package com.ashupandey.footballtutorails.recycler.resource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ashupandey.footballtutorails.MainActivity
import com.ashupandey.footballtutorails.R
import kotlinx.android.synthetic.main.recycler_layout.view.*

class CustomAdapter(val list: MutableList<Data>, val obj: MainActivity): RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener{
                obj.itemClickedListner(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_layout,
            parent,
            false
        )
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.skillText.text = list[position].skill
        holder.itemView.skillImage.setImageResource(list[position].imageResId)
    }

    override fun getItemCount(): Int {
       return list.size
    }


}

interface ItemClicked{
    fun itemClickedListner(position: Int)
}