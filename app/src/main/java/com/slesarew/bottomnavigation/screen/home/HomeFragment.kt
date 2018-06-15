package com.slesarew.bottomnavigation.screen.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.slesarew.bottomnavigation.R
import kotlinx.android.synthetic.main.home_fragment.go_to_second_level as goToSecondLevel

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.home_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToSecondLevel.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_homeSecondLevelFragment)
        }
    }
}