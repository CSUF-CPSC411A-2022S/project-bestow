package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.testproject.databinding.ActivityMainBinding

/**
 * Main interface of the application
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create data binding and assign layout for the activity.
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Setup navigation controller and action bar.
        val navController = this.findNavController(R.id.nav_host)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    /**
     * Override the default implementation of the Up button so that it uses our
     * navController.
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host)
        return navController.navigateUp()
    }
}