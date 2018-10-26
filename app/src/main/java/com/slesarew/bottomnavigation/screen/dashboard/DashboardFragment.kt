package com.slesarew.bottomnavigation.screen.dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slesarew.bottomnavigation.R
import com.slesarew.bottomnavigation.extension.navigateOnClickTo
import kotlinx.android.synthetic.main.dashboard_fragment.go_to_second_level as goToSecondLevel

class DashboardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.dashboard_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToSecondLevel.navigateOnClickTo {
            R.id.action_dashboardFragment_to_dashboardSecondLevelFragment
        }
    }
}