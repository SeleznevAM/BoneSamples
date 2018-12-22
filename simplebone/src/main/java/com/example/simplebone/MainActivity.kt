package com.example.simplebone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bone = HelloBone()
            .also {
                it.isActive = true
                it.text = "Hello my first bone!!!"
            }

        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, bone.sibling as Fragment)
            .commit()
    }
}
