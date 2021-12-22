package com.example.databaseimplimentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.databaseimplimentation.R
import com.example.databaseimplimentation.daos.AppDataBase
import com.example.databaseimplimentation.databinding.FragmentEnteryBinding


class FragmentEntry : Fragment() {



    private  var binding : FragmentEnteryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEnteryBinding.inflate(
            inflater,
            container,
            false
        )

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //do your work here




    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}