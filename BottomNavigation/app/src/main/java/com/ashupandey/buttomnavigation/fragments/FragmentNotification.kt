package com.ashupandey.buttomnavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashupandey.buttomnavigation.R
import com.ashupandey.buttomnavigation.databinding.FragmentHomeBinding
import com.ashupandey.buttomnavigation.databinding.FragmentNotificationBinding


class FragmentNotification : Fragment() {
    var _binding: FragmentNotificationBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(inflater,
            container,
            false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textView.text = "Notification Frag"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}