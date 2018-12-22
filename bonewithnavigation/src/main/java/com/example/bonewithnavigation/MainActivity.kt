package com.example.bonewithnavigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import pro.horovodovodo4ka.bones.BoneSibling
import pro.horovodovodo4ka.bones.extensions.glueWith


class MainActivity : AppCompatActivity(), BoneSibling<FingerNavigationBone> {
    override var bone: FingerNavigationBone = FingerNavigationBone(ListBone()).also { it.isActive = true }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        glueWith(bone)

        supportFragmentManager.beginTransaction().add(android.R.id.content, (bone.fingertip?.sibling as Fragment)).commit()


    }
}
