package com.slesarew.bottomnavigation.screen.profilesecondlevel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.slesarew.bottomnavigation.R

class ProfileSecondLevelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(
        R.layout.profile_second_level_fragment,
        container,
        false
    )
}