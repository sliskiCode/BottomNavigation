package com.slesarew.bottomnavigation.main

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.slesarew.bottomnavigation.R
import com.slesarew.bottomnavigation.extension.hideAllNavHostsExcept
import com.slesarew.bottomnavigation.extension.setupActionBarWithNavController
import com.slesarew.bottomnavigation.extension.toArrayList
import com.slesarew.bottomnavigation.extension.toStack
import java.util.Stack
import kotlinx.android.synthetic.main.activity_graph_per_tab.bottom_navigation as bottomNavigation

private const val TAB_IDS = "com.slesarew.bottomnavigation.main.GraphPerTabActivity.TAB_IDS"

class GraphPerTabActivity : AppCompatActivity() {

    @IdRes
    private var tabIds = Stack<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph_per_tab)

        /**
         * In case of first launch home tab is presented for the user.
         * In case of restoring state after process being killed we use saved tab id and show it to the user.
         */
        savedInstanceState?.let {
            tabIds = savedInstanceState.getIntegerArrayList(TAB_IDS).toStack()
            showNavHost(tabIds.pop())
        } ?: showNavHost(R.id.home_tab)

        /**
         * Wiring bottom navigation click with navigation.
         */
        bottomNavigation.setOnNavigationItemSelectedListener { showNavHost(it.itemId).let { true } }
    }

    /**
     * Saving current tab id in case of application being killed by the OS.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putIntegerArrayList(TAB_IDS, tabIds.toArrayList())
    }

    /**
     * Function is responsible for managing graphs back stack properly.
     * 1. It is popping back stack of particular graph.
     * 2. When particular graph's back stack is empty it pop a tab and select the youngest one in the stack.
     * 3. When tabs stack is empty it delegates on back press to the system.
     */
    override fun onBackPressed() {
        findNavController(tabIds.peek())
            .popBackStack()
            .not()
            .also { shouldClose ->
                if (shouldClose) {
                    tabIds.pop()
                    if (tabIds.isEmpty()) super.onBackPressed() else selectYoungestTab()
                }
            }
    }

    /**
     * Function pops the youngest tab and select it. It will bottom navigation will automatically call
     * setOnNavigationItemSelectedListener and out showNavHost().
     */
    private fun selectYoungestTab() = tabIds.pop().also { bottomNavigation.selectedItemId = it }

    /**
     * Setup code. Taken from documentation. ¯\_(ツ)_/¯
     */
    override fun onSupportNavigateUp(): Boolean = findNavController(tabIds.peek()).navigateUp()

    /**
     * Function is responsible for switching content between tabs.
     *
     * 1. Cache current tab.
     * 2. Finding graph by tab id and update ActionBar with it.
     * 3. Hiding all graphs except new current tab id.
     */
    private fun showNavHost(@IdRes tabId: Int) = tabIds.push(tabId).also {
        setupActionBarWithNavController(it)
        hideAllNavHostsExcept(it)
    }
}