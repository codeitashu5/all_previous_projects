package com.example.connectapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.connectapp.R
import com.example.connectapp.databinding.ActivityMainBinding
import com.example.connectapp.databinding.ActivitySupplyBinding
import com.example.connectapp.fragment.walkthrough.FirstFragment
import com.example.connectapp.fragments.RegisterFragment
import com.example.connectapp.view.pager.ViewPagerWalkThrough
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SupplyActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySupplyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupplyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list: MutableList<Fragment> = mutableListOf()
        list.add(RegisterFragment())
        list.add(FirstFragment())
        list.add(FirstFragment())

        binding.viewPager.adapter = ViewPagerWalkThrough(supportFragmentManager, list)

    }
}