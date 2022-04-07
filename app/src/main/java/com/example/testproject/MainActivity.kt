package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.testproject.databinding.ActivityMainBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = this.findNavController(R.id.nav)
        NavigationUI.setupActionBarWithNavController(this,navController)



            }


    override fun onSupportNavigateUp(): Boolean {
        //        Replace nav_host with the name of your nav host fragment in activity_main.xml
        val navController = this.findNavController(R.id.nav)
        return navController.navigateUp()
    }
}