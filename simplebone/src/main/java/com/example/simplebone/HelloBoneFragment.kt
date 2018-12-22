package com.example.simplebone

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pro.horovodovodo4ka.bones.BoneSibling
import pro.horovodovodo4ka.bones.Phalanx
import pro.horovodovodo4ka.bones.ui.delegates.Page


class HelloBone : Phalanx(){
    override val seed = { HelloBoneFragment() }

    var text = ""
}


class HelloBoneFragment : Fragment(), BoneSibling<HelloBone> by Page() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hello_bone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}