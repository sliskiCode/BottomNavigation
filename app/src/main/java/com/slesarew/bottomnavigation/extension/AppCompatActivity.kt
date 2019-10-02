package com.slesarew.bottomnavigation.extension

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

fun AppCompatActivity.hideAllNavHostsExcept(@IdRes navHostId: Int) =
    with(supportFragmentManager) {
        fragments
            .filterIsInstance(NavHostFragment::class.java)
            .forEach { fragment ->
                beginTransaction()
                    .let { transaction ->
                        if (fragment.id == navHostId) {
                            transaction.show(fragment)
                        } else {
                            transaction.hide(fragment)
                        }
                    }
                    .commit()
            }
    }

fun AppCompatActivity.setupActionBarWithNavController(@IdRes navHostId: Int) =
    setupActionBarWithNavController(findNavController(navHostId))