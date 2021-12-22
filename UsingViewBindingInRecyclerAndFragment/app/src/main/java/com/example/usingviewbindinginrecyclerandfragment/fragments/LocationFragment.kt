package com.example.usingviewbindinginrecyclerandfragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.usingviewbindinginrecyclerandfragment.R
import com.example.usingviewbindinginrecyclerandfragment.databinding.FragmentLocationBinding
import com.example.usingviewbindinginrecyclerandfragment.model.LocationModel


class LocationFragment : Fragment() {

    private val viewModel : LocationModel by viewModels()
    private var binding : FragmentLocationBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_location,
            container,
            false
        )

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //our work goes here
        

        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}