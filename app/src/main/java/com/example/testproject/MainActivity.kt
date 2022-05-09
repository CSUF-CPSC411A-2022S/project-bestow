package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.testproject.databinding.ActivityMainBinding

import androidx.fragment.app.Fragment
import com.example.testproject.fragments.AccountFragment
import com.example.testproject.fragments.HomeFragment
import com.example.testproject.fragments.PostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView




/**
 * Main interface of the application
 */
class MainActivity : AppCompatActivity() {



    private val homeFragment = HomeFragment()
    private val accountFragment = AccountFragment()
    private val postFragment = PostFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home-> replaceFragment(homeFragment)
                R.id.post-> replaceFragment(postFragment)
                R.id.account-> replaceFragment(accountFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }

    }
}