package com.example.lab_mobdev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Lab2 : AppCompatActivity() {
    private var counterTxt: TextView? = null
    private var incrementBtn: Button? = null
    private var value = 0
    private val clickListener =
        View.OnClickListener { v ->
            when (v.id) {
                R.id.incBtn -> incrementCounter()
            }
        }

    fun getValue(): Int {
        return this.value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2)
        value = 0
        counterTxt = findViewById<View>(R.id.textView) as TextView
        incrementBtn = findViewById<View>(R.id.incBtn) as Button
        incrementBtn!!.setOnClickListener(clickListener)
        initCounter()
    }

    fun initCounter() {
        this.value = 0
        counterTxt?.text = this.value.toString()
    }


    fun incrementCounter() {
        this.value++
        counterTxt?.text = this.value.toString()
    }

}