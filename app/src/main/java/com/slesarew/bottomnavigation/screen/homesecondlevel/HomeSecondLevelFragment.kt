package com.slesarew.bottomnavigation.screen.homesecondlevel

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slesarew.bottomnavigation.R

class HomeSecondLevelFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.home_second_level_fragment, container, false)
}