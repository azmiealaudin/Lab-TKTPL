package com.example.lab_mobdev


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Lab2InstrumentedTest {

    @Test
    fun test_all_visibilities() {
        val activitySceneario = ActivityScenario.launch(Lab2::class.java)
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.incBtn)).check(matches(isDisplayed()))
    }

    @Test
    fun test_can_button_be_clicked(){
        val activitySceneario = ActivityScenario.launch(Lab2::class.java)
        onView(withId(R.id.incBtn)).perform(click())
    }
