package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testproject.fragments.AccountFragment
import com.example.testproject.fragments.HomeFragment
import com.example.testproject.fragments.PostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val accountFragment = AccountFragment()
        val postFragment = PostFragment()

    }
}