package com.slesarew.bottomnavigation.main

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.slesarew.bottomnavigation.R
import com.slesarew.bottomnavigation.extension.hideAllNavHostsExcept
import com.slesarew.bottomnavigation.extension.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_graph_per_tab.bottom_navigation as bottomNavigation

class GraphPerTabActivity : AppCompatActivity() {

    @IdRes
    private var currentTabId = R.id.home_tab

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph_per_tab)

        /**
         * Showing home tab as first.
         */
        showNavHost(currentTabId)

        /**
         * Wiring bottom navigation click with navigation.
         */
        bottomNavigation.setOnNavigationItemSelectedListener { showNavHost(it.itemId).let { true } }
    }

    override fun onBackPressed() =
        findNavController(currentTabId)
            .popBackStack()
            .not()
            .let { shouldClose ->
                if (shouldClose) super.onBackPressed()
            }

    /**
     * Setup code. Taken from documentation. ¯\_(ツ)_/¯
     */
    override fun onSupportNavigateUp(): Boolean =
        findNavController(currentTabId).navigateUp()

    /**
     * Function is responsible for switching content between tabs.
     *
     * 1. Cache current tab.
     * 2. Finding graph by tab id and update ActionBar with it.
     * 3. Hiding all graphs except new current tab id.
     */
    private fun showNavHost(@IdRes tabId: Int) {
        currentTabId = tabId

        setupActionBarWithNavController(currentTabId)
        hideAllNavHostsExcept(currentTabId)
    }
}