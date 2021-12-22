package com.example.apicalling

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val list : List<Data>):
   RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
   class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(
         R.layout.recyler_layout,
         parent,
         false
      )
      return ViewHolder(view)
   }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val id = holder.itemView.findViewById<TextView>(R.id.idText)
      val name = holder.itemView.findViewById<TextView>(R.id.name)
      val email = holder.itemView.findViewById<TextView>(R.id.email)

      email.text = list[position].email
      name.text = list[position].first_name
      id.text = list[position].last_name
   }

   override fun getItemCount(): Int {
     return list.size
   }
}