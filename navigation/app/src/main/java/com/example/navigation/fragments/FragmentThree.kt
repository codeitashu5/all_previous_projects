package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.navigation.R
import com.example.navigation.databinding.FragmentOneBinding
import com.example.navigation.databinding.FragmentThreeBinding

class FragmentThree : Fragment() {

    private var binding : FragmentThreeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_three,
            container,
            false
        )
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //your work goes here
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
    }
