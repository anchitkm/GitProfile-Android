package com.anchit.gitprofile

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anchit.gitprofile.utils.UIAutomationUtils
import com.anchit.gitprofile.view.HomeActivity
import org.junit.*
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class GitProfileTest {


    /* Instantiate an ActivityScenarioRule object. */
    @get:Rule
    var activityRule: ActivityScenarioRule<HomeActivity> =
        ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    /**
     * Passing this test case means expected view is not rendered on Launch, as we are passing wrong view which should not be visible
     */
    @Test
    fun isIncorrectHomeLaunched() {
        Assert.assertFalse(
            UIAutomationUtils.waitForExist(
                R.id.civ_profile_picture,
                2000
            )
        )  //used Assert False
    }

    @Test
    fun isCorrectHomeLaunched() {
        Assert.assertTrue(UIAutomationUtils.waitForExist(R.id.et_search_bar, 2000))
    }

    @Test
    fun isHintVisibleOnEditText() {
        Assert.assertTrue(UIAutomationUtils.waitForExistTextHint(R.string.search))
    }

    @Test
    fun performSearchOperation() {

//        Assert.assertTrue(UIAutomationUtils.waitForExist(R.id.et_search_bar,2000))
        UIAutomationUtils.enterText(R.id.et_search_bar, "anchitkm", 2000, true)
        Assert.assertTrue(UIAutomationUtils.waitForExist(R.id.civ_profile_picture, 10000))
    }

    @Test
    fun checkForNameInResult() {
        performSearchOperation()
        Assert.assertTrue(
            UIAutomationUtils.waitForExistTextCompleteDisplayed(
                "Anchit Mittal",
                2000
            )
        )
    }

    @Test
    fun checkForUserNameInResult() {
        performSearchOperation()
        Assert.assertTrue(UIAutomationUtils.waitForExistTextCompleteDisplayed("anchitkm", 2000))
    }

    @Test
    fun checkForLocationInResult() {
        performSearchOperation()
        Assert.assertTrue(UIAutomationUtils.waitForExistTextCompleteDisplayed("Noida", 2000))
    }

    @Test
    fun checkForRepoCountInResult() {
        performSearchOperation()
        Assert.assertTrue(
            UIAutomationUtils.waitForExistTextCompleteDisplayed(
                "9 Public Repositories",
                2000
            )
        )
    }
    @Test
    fun checkForGitProfileUrlInResult() {
        performSearchOperation()
        Assert.assertTrue(UIAutomationUtils.waitForExistTextCompleteDisplayed("https://github.com/anchitkm",2000))
    }





}