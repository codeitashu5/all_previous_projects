package com.ashupandey.buttomnavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashupandey.buttomnavigation.R
import com.ashupandey.buttomnavigation.databinding.FragmentHomeBinding
import com.ashupandey.buttomnavigation.databinding.FragmentSearchBinding


class FragmentSearch : Fragment() {
    var _binding: FragmentSearchBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater,
            container,
            false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textView.text = "Search Frag"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}