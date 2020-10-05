package com.example.lab_mobdev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_stopwatch.*
import kotlin.system.exitProcess

class stopwatch : AppCompatActivity() {

    var handler: Handler = Handler()
    var runnable:Runnable = Runnable{}
    var msecond:Int = 0
    var second:Int = 0
    var minute:Int = 0
    var stopwatchOn=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        play.setOnClickListener {
            stopwatchStart()
        }

        pause.setOnClickListener {
            stopwatchPause()
        }

        reset.setOnClickListener {
            stopwatchReset()
        }

        exit.setOnClickListener {
            stopwatchExit()
        }

    }
    fun stopwatchStart(){
        stopwatchOn=true
        handler.removeCallbacks(runnable)
        runnable = object:Runnable{
            override fun run(){
                msecond+=1
                if (msecond==100){
                    msecond=0
                    second+=1
                }
                if (second==60){
                    second=0
                    minute+=1
                }
                stopwatch_msec.text=msecond.toString()
                stopwatch_sec.text=second.toString()
                stopwatch_min.text=minute.toString()
                if (minute == 60){
                    handler.removeCallbacks(runnable)
                    return
                }
                handler.postDelayed(this,1)
            }
        }
        handler.post(runnable)
    }

    fun stopwatchPause(){
        stopwatchOn=false
        handler.removeCallbacks(runnable)
    }

    fun stopwatchReset(){
        stopwatchOn=false
        handler.removeCallbacks(runnable)
        msecond = 0
        second = 0
        minute = 0
        stopwatch_msec.text=msecond.toString()
        stopwatch_sec.text=second.toString()
        stopwatch_min.text=minute.toString()
    }

    override fun onPause() {
        super.onPause()
        if (stopwatchOn){
            super.onResume()
        }
    }

    fun stopwatchExit(){
        exitProcess(-1)
    }

    override fun onBackPressed() {
        val toast = Toast.makeText(
            applicationContext,
            "Please exit by pressing exit button:)",
            Toast.LENGTH_SHORT
        )
        toast.show()
    }
}