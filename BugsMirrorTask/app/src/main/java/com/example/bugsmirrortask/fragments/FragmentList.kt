package com.example.bugsmirrortask.fragments

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bugsmirrortask.CustomAdapter
import com.example.bugsmirrortask.ItemClickedListener
import com.example.bugsmirrortask.R
import com.example.bugsmirrortask.databinding.FragmentListBinding

//the list will get constructed every time and will not get removed fragment
val list1 =  mutableListOf<String>()
class FragmentList : Fragment(),ItemClickedListener {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        arguments?.let {
            val text = it.getString("element").toString()
            list1.add(text)
        }


        recyclerView = binding.recyclerView
        recyclerView.adapter = CustomAdapter(list1,this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(pos: Int,text:String) {
        val queryUri = Uri.parse("https://www.google.com/search?q=${text}")
        val i = Intent(ACTION_VIEW,queryUri)
        startActivity(i)
    }
}