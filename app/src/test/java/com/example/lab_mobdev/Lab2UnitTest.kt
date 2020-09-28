package com.example.lab_mobdev


import junit.framework.Assert
import junit.framework.Assert.assertEquals
import org.junit.Test

class Lab2Test {

    @Test
    fun getValue() {
        val counter = Lab2()
        counter.initCounter()
        Assert.assertNotNull(counter.getValue())
    }

    @Test
    fun test_init_value() {
        val counter = Lab2()
        counter.initCounter()
        println(counter.getValue())
        assertEquals(0, counter.getValue())
    }

    @Test
    fun test_increment() {
        val counter = Lab2()
        counter.incrementCounter()
        println(counter.getValue())
        assertEquals(1, counter.getValue())
    }
}

