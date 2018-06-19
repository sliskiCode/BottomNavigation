package com.slesarew.bottomnavigation.main

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import com.slesarew.bottomnavigation.R
import com.slesarew.bottomnavigation.extension.hideAllNavHostsExcept
import com.slesarew.bottomnavigation.extension.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.bottom_navigation as bottomNavigation

private const val NAV_HOST = "com.slesarew.bottomnavigation.main.GraphPerTabActivity.NAV_HOST"

class GraphPerTabActivity : AppCompatActivity() {

    @IdRes
    private var currentNavHostId = R.id.dashboard_nav_host

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            currentNavHostId = it.getInt(NAV_HOST)
            setupActionBarWithNavController(currentNavHostId)
        } ?: showNavHost(currentNavHostId)

        bottomNavigation.setOnNavigationItemSelectedListener { showNavHost(it.itemId) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(NAV_HOST, currentNavHostId)
    }

    override fun onBackPressed() {
        val didPop = findNavController(currentNavHostId).popBackStack()

        if (!didPop) super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(currentNavHostId).navigateUp()

    private fun showNavHost(@IdRes navHostId: Int): Boolean {
        currentNavHostId = navHostId
        setupActionBarWithNavController(currentNavHostId)
        hideAllNavHostsExcept(currentNavHostId)

        return true
    }
}