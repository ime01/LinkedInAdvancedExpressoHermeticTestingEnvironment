package com.flowz.linkedinadvancedexpressohermetictestingenvironment

//import android.support.test.InstrumentationRegistry
//import android.support.test.espresso.Espresso.onView
//import android.support.test.espresso.assertion.ViewAssertions.matches
//import android.support.test.espresso.matcher.ViewMatchers.withId
//import android.support.test.espresso.matcher.ViewMatchers.withText
//import android.support.test.rule.ActivityTestRule
//import android.support.test.runner.AndroidJUnit4
import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.joda.time.DateTime
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
  @get:Rule
  var activityRule = ActivityTestRule(MainActivity::class.java, true, false)

  @Test
  fun evening() {
    val app = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestApplication
//    val app = InstrumentationRegistry.getTargetContext().applicationContext as TestApplication
//    app.setClock(object: Clock() {
//      override fun getNow(): DateTime {
//        return DateTime().withHourOfDay(20)
//      }
//    })

//    val clock = app.provideClock()
    val clock = Mockito.mock(Clock::class.java)
    app.component = DaggerTestComponent.builder()
      .clock(clock)
      .build()

    Mockito.`when`(clock.getNow()).thenReturn(DateTime().withHourOfDay(20))

    activityRule.launchActivity(null)

    onView(withId(R.id.greeting))
      .check(ViewAssertions.matches(withText(R.string.greeting_evening)))
  }
}