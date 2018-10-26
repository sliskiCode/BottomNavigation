package com.slesarew.bottomnavigation.extension

import android.view.View
import androidx.navigation.Navigation.createNavigateOnClickListener

fun View.navigateOnClickTo(idBlock: () -> Int) =
        setOnClickListener(createNavigateOnClickListener(idBlock()))