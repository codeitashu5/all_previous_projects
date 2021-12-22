package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigation.R
import com.example.navigation.databinding.FragmentOneBinding
import com.example.navigation.recycler.resources.Item
import com.example.navigation.recycler.resources.ItemListAdapter

class FragmentOne : Fragment() {

    private var _binding : FragmentOneBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_one,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //your work goes here
        val list:MutableList<Item> = mutableListOf()
        for(i in 1..10){
            //creating dummy data
            val item  = Item(getString(R.string.random),getString(R.string.random),getString(R.string.random))
            list.add(item)
        }

        binding.recycler.adapter = ItemListAdapter(requireContext(),list)
        binding.recycler.layoutManager = GridLayoutManager(requireContext(),2)
       //binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}