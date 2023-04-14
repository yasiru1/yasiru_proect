package com.yasiru.inntavola

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yasiru.inntavola.ui.MainActivity
import com.yasiru.inntavola.ui.items.ItemsAdapter
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class HomeFragmentTest {

    @get:Rule val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun test_isListVisible_onAppLaunch() {
        onView(withId(R.id.item_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectListItem_isDetailFragmentVisible() {
        onView(withId(R.id.item_recycler_view)).perform(
            RecyclerViewActions.scrollToPosition<ItemsAdapter.ItemViewHolder>(0)
        )
        onView(withId(R.id.item_recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ItemsAdapter.ItemViewHolder>(0, click())
        )
        onView(withId(R.id.itemDetailFragment)).check(matches(isDisplayed()))
    }
}
