package com.example.connectapp.fragment.walkthrough

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.connectapp.R
import com.example.connectapp.databinding.FragmentFirstBinding
import com.example.connectapp.databinding.FragmentHomeBinding
import com.example.connectapp.fragments.HomeFragment
import com.example.connectapp.view.pager.ViewPagerWalkThrough


class FirstFragment : Fragment() {
    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_first,
            container,
            false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //your code goes here

    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}