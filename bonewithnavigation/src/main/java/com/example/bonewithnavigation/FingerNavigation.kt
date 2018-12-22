package com.example.bonewithnavigation

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pro.horovodovodo4ka.bones.Bone
import pro.horovodovodo4ka.bones.Finger
import pro.horovodovodo4ka.bones.ui.FingerNavigatorInterface
import pro.horovodovodo4ka.bones.ui.delegates.FingerNavigator

class FingerNavigationBone(rootBone: Bone) : Finger(rootBone) {
    override val seed = { FingerNavigation() }
}

class FingerNavigation : Fragment(), FingerNavigatorInterface<FingerNavigationBone> by FingerNavigator(R.id.container) {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        managerProvider = :: getChildFragmentManager
    }

    override fun onDetach() {
        super.onDetach()
        managerProvider = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_finger_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!isResumed) return
        refreshUI()
    }
}