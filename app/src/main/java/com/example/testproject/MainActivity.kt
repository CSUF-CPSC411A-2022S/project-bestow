package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.testproject.databinding.ActivityMainBinding

/**
 * An application that modifies a user's profile.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Use a binding object to simplify access to the visual design elements.
         */
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Remove comments only when working on 6.1 Model 3.
         * navController refers to our navigation fragment. The setupActionBarWithnavController
         * method connects our navController to the ActionBar that maintains the "back stack" which
         * is the succession of fragments that were opened. Pressing the Up button will display the
         * fragment that opened the current fragment, thereby back tracking its way to the first
         * fragment.
         */
        //val navController = this.findNavController(R.id.nav_host)
        //NavigationUI.setupActionBarWithNavController(this,navController)

    }
    /**
     * Remove comments only when working on 6.1 Model 3.
     * The method overrides the default implementation of the Up button so that it uses our
     * navController.
     */
    /*
    override fun onSupportNavigateUp(): Boolean {
        //Replace nav_host with the name of your nav host fragment in activity_main.xml
        val navController = this.findNavController(R.id.nav_host)
        return navController.navigateUp()
    }
    */

}