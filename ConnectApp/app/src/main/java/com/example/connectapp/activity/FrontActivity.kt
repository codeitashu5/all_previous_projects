package com.example.connectapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.connectapp.R
import com.example.connectapp.databinding.ActivityFrontBinding
import com.example.connectapp.fragment.walkthrough.FirstFragment
import com.example.connectapp.view.pager.ViewPagerWalkThrough
import kotlinx.coroutines.*

class FrontActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFrontBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrontBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //write your code here
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            launch (Dispatchers.Main){
                val intent = Intent(this@FrontActivity,SupplyActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}