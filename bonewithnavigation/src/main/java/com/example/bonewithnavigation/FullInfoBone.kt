package com.example.bonewithnavigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_full_info.*
import pro.horovodovodo4ka.bones.BoneSibling
import pro.horovodovodo4ka.bones.Phalanx
import pro.horovodovodo4ka.bones.ui.delegates.Page

class FullInfoBone(val text : String) : Phalanx() {
    override val seed = { FullInfoFragment() }
}

class FullInfoFragment : Fragment(), BoneSibling<FullInfoBone> by Page() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_full_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        info.text = bone.text
    }

}