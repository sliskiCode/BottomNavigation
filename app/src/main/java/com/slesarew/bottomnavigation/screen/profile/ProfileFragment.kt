package com.slesarew.bottomnavigation.screen.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.slesarew.bottomnavigation.R
import com.slesarew.bottomnavigation.extension.navigateOnClickTo
import kotlinx.android.synthetic.main.dashboard_fragment.go_to_second_level as goToSecondLevel

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(
        R.layout.profile_fragment,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToSecondLevel.navigateOnClickTo {
            R.id.action_profileFragment_to_profileSecondLevelFragment
        }
    }
}