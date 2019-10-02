package com.slesarew.bottomnavigation.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.slesarew.bottomnavigation.R
import com.slesarew.bottomnavigation.extension.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_one_graph.bottom_navigation as bottomNavigation

@SuppressLint("Registered")
class OneGraphActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_graph)

        bottomNavigation.setupWithNavController(findNavController(R.id.main_nav_host))
        setupActionBarWithNavController(R.id.main_nav_host)
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.main_nav_host).navigateUp()
}