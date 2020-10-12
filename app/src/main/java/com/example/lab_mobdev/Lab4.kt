package com.example.lab_mobdev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab_mobdev.ui.main.Lab4Fragment

class Lab4 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab4_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, Lab4Fragment.newInstance())
                .commitNow()
        }
    }
}