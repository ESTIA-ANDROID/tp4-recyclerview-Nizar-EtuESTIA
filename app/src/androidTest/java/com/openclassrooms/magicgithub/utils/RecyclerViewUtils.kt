package com.openclassrooms.magicgithub.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers
import com.openclassrooms.magicgithub.R
import org.hamcrest.Matcher
import org.junit.Assert

object RecyclerViewUtils {
    @JvmStatic
    fun clickChildView(id: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.withId(R.id.activity_list_user_fab)
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun perform(uiController: UiController, view: View) {
                val v = view.findViewById<View>(id)
                v.performClick()
            }
        }
    }

    class ItemCount(private val expectedCount: Int) : ViewAssertion {
        override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
            val recyclerView = view as RecyclerView
            val adapter = recyclerView.adapter
            Assert.assertNotNull(adapter)
            Assert.assertEquals(adapter!!.itemCount.toLong(), expectedCount.toLong())
        }
    }
}