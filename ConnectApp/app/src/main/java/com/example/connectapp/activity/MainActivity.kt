package com.example.connectapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.connectapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    //search the
    private lateinit var  navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHost.navController
        setupActionBarWithNavController(navController)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        NavigationUI.setupWithNavController(bottomNavigationView,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || return super.onSupportNavigateUp()
    }
}