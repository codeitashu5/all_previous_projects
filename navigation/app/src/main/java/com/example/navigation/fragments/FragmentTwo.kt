package com.example.navigation.fragments

import android.os.Bundle
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.MotionPlaceholder
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Placeholder
import androidx.databinding.DataBindingUtil
import com.example.navigation.R
import com.example.navigation.databinding.FragmentOneBinding
import com.example.navigation.databinding.FragmentTwoBinding


class FragmentTwo : Fragment() {
    private var _binding : FragmentTwoBinding? = null
    private val binding get() = _binding!!
    private lateinit var layout : ConstraintLayout
    private lateinit var placeHolder: Placeholder
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_two,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //your work goes here
        placeHolder = binding.placHolder
        layout = binding.constraintLayout

        binding.imageView.setOnClickListener {
            TransitionManager.beginDelayedTransition(layout)
            placeHolder.setContentId(it.id)
        }
        binding.imageView.setOnClickListener {
            TransitionManager.beginDelayedTransition(layout)
            placeHolder.setContentId(it.id)
        }
        binding.imageView2.setOnClickListener {
            TransitionManager.beginDelayedTransition(layout)
            placeHolder.setContentId(it.id)
        }
        binding.imageView3.setOnClickListener {
            TransitionManager.beginDelayedTransition(layout)
            placeHolder.setContentId(it.id)
        }
        binding.imageView4.setOnClickListener {
            TransitionManager.beginDelayedTransition(layout)
            placeHolder.setContentId(it.id)
        }
        binding.imageView5.setOnClickListener {
            TransitionManager.beginDelayedTransition(layout)
            placeHolder.setContentId(it.id)
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}