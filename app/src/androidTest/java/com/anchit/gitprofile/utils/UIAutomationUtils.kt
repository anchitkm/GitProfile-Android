package com.anchit.gitprofile.utils

import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText


object UIAutomationUtils {

    private val TAG = UIAutomationUtils::class.java.name

    /**
     * This method will search on UI for View matching given resourceId. It will wait maximum of
     * given time in milli second for view to appear on screen. If view appear before given time it
     * will return immediately. If there any animations running on device affecting its visibility
     * this will wait for the view to displayed on UI completely
     *
     * @param resourceId Resource id as defined by R.id.resourceId for the element to be searched on
     * UI
     * @param millis     Maximum time duration in milli seconds to wait for text to appear on UI
     * @return true if matching view is found in given time, false otherwise
     */
    fun waitForExist(resourceId: Int, millis: Long): Boolean {
        var isViewFound = false
        val endTime = System.currentTimeMillis() + millis
        while (System.currentTimeMillis() < endTime) {
            try {
                Espresso.onView(withId(resourceId)).check(
                    matches(withId(resourceId))
                )
                    .check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                isViewFound = true
                break
            } catch (t: Throwable) {
                Log.d(TAG, "View not found on screen")
                try {
                    Thread.sleep(DummyTestConstants.WAIT_TIME_UI_REFRESH)
                } catch (e: InterruptedException) {
                    Log.d(
                        TAG,
                        "thread interrupted while waiting for screen refresh" + e.localizedMessage
                    )
                }
            }
        }
        return isViewFound
    }

    /**
     * This method will search on UI for View matching given stringResourceId. It will wait maximum
     * of given time in milli second for view to appear on screen. If view appear before given time
     * it will return immediately.
     *
     * @param stringResourceId Resource id as defined by R.string.id for the string to be searched
     * on UI
     * @return true if matching view is found in given time, false otherwise
     */
    fun waitForExistTextHint(stringResourceId: Int): Boolean {
        var isViewFound = false
        val endTime = System.currentTimeMillis() + DummyTestConstants.DEFAULT_MILLIS
        while (System.currentTimeMillis() < endTime) {
            try {
                Espresso.onView(ViewMatchers.withHint(stringResourceId))
                    .check(matches(ViewMatchers.isCompletelyDisplayed()))
                isViewFound = true
                break
            } catch (t: Throwable) {
                Log.d(TAG, "View not found on screen")
                try {
                    Thread.sleep(DummyTestConstants.WAIT_TIME_UI_REFRESH)
                } catch (e: InterruptedException) {
                    Log.d(
                        TAG,
                        "thread interrupted while waiting for screen refresh" + e.localizedMessage
                    )
                }
            }
        }
        return isViewFound
    }

    /**
     * This method will search on UI for View (Edit Text) matching given resourceId. It will wait
     * maximum of given time in milli second for view to appear on screen. If view appear before
     * given time it will return immediately. If there any animations running on device affecting
     * its visibility this will wait for the view to displayed on UI completely
     *
     * @param resourceId      Resource id as defined by R.id.resourceId for the element to be
     * searched on UI
     * @param textToBeEntered Text to enter in the field
     * @param millis          Maximum time duration in milli seconds to wait for text to appear on
     * UI
     * @param performImeAfter true if after entering text ime click action has to be performed,
     * false otherwise
     * @return true if matching view is found in given time, false otherwise
     */
    fun enterText(
        resourceId: Int,
        textToBeEntered: String?,
        millis: Long,
        performImeAfter: Boolean
    ): Boolean {
        var isTextEntered = false
        val endTime = System.currentTimeMillis() + millis
        while (System.currentTimeMillis() < endTime) {
            try {
                if (performImeAfter) {
                    Espresso.onView(withId(resourceId)).check(matches(withId(resourceId)))
                        .check(matches(ViewMatchers.isCompletelyDisplayed()))
                        .perform(ViewActions.typeText(textToBeEntered))
                        .perform(ViewActions.pressImeActionButton())
                } else {
                    Espresso.onView(withId(resourceId)).check(matches(withId(resourceId)))
                        .check(matches(ViewMatchers.isCompletelyDisplayed()))
                        .perform(ViewActions.typeText(textToBeEntered))
                }
                isTextEntered = true
                break
            } catch (t: Throwable) {
                Log.d(TAG, "View not found on screen")
                try {
                    Thread.sleep(DummyTestConstants.WAIT_TIME_UI_REFRESH)
                } catch (e: InterruptedException) {
                    Log.d(
                        TAG,
                        "thread interrupted while waiting for screen refresh" + e.localizedMessage
                    )
                }
            }
        }
        return isTextEntered
    }

    /**
     * This method will search on UI for View matching given resourceId. Once the resource is found
     * it will perform click action on the view.
     *
     * @param resourceId Resource id as defined by R.id.resourceId for the element to be searched on
     * UI
     * @return true if matching view is found , false otherwise
     */
    fun performClick(resourceId: Int): Boolean {
        val isViewFound: Boolean = waitForExistCompleteDisplayed(
            resourceId,
            DummyTestConstants.WAIT_TIME_SEARCH_VIEW
        )
        if (isViewFound) {
            try {
                Espresso.onView(withId(resourceId))
                    .check(matches(withId(resourceId)))
                    .perform(ViewActions.click())
            } catch (e: Exception) {
                Log.e(TAG, ""+e.localizedMessage)
            }
        }
        return isViewFound
    }

    fun waitForExistCompleteDisplayed(resourceId: Int, millis: Long): Boolean {
        var isViewFound = false
        val endTime = System.currentTimeMillis() + millis
        while (System.currentTimeMillis() < endTime) {
            try {
                Espresso.onView(withId(resourceId)).check(
                    matches(withId(resourceId))
                )
                isViewFound = true
                break
            } catch (t: Throwable) {
                Log.d(TAG, "View not found on screen")
                try {
                    Thread.sleep(DummyTestConstants.WAIT_TIME_UI_REFRESH)
                } catch (e: InterruptedException) {
                    Log.d(
                        TAG,
                        "thread interrupted while waiting for screen refresh" + e.localizedMessage
                    )
                }
            }
        }
        return isViewFound
    }

    fun waitForExistTextCompleteDisplayed(text: String?, millis: Long): Boolean {
        var isViewFound = false
        val endTime = System.currentTimeMillis() + millis
        while (System.currentTimeMillis() < endTime) {
            try {
                Espresso.onView(withText(text)).check(
                    matches(withText(text))
                )
                    .check(matches(ViewMatchers.isCompletelyDisplayed()))
                isViewFound = true
                break
            } catch (t: Throwable) {
                Log.d(TAG, "View not found on screen")
                try {
                    Thread.sleep(DummyTestConstants.WAIT_TIME_UI_REFRESH)
                } catch (e: InterruptedException) {
                    Log.d(
                        TAG,
                        "thread interrupted while waiting for screen refresh" + e.localizedMessage
                    )
                }
            }
        }
        return isViewFound
    }
}