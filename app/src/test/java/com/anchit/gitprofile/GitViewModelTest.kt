package com.anchit.gitprofile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.anchit.gitprofile.model.UserInfo
import com.anchit.gitprofile.model.UserProfile
import com.anchit.gitprofile.model.UserRepos
import com.anchit.gitprofile.network.APIService
import com.anchit.gitprofile.repo.GitProfileRepository
import com.anchit.gitprofile.utils.TestCoroutineRule
import com.anchit.gitprofile.viewmodel.GitViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GitViewModelTest {

    private var viewModel: GitViewModel? = null

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var gitRepo: GitProfileRepository

    @Mock
    lateinit var apiService: APIService


    @Mock
    private lateinit var apiUsersObserver: Observer<UserInfo>

    @Mock
    private lateinit var apiUserRepoObserver: Observer<UserRepos>

    @Mock
    private lateinit var apiUsersProfileObserver: Observer<UserProfile>

    private val username:String="anchitkm"



    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = GitViewModel()

    }


    @Test
    fun getUserRepo_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(UserRepos())
                .`when`(apiService)
                .getUserRepo(username)

//            val viewModel = GitViewModel()
//            viewModel.userRepos.observeForever(apiUserRepoObserver)
            verify(apiService).getUserRepo(username).isSuccessful
//            viewModel.userRepos.removeObserver(apiUserRepoObserver)
        }
    }
    @Test
    fun getUserProfile_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(UserProfile())
                .`when`(apiService)
                .getUserProfile(username)
            val viewModel = GitViewModel()
            viewModel.userProfile.observeForever(apiUsersProfileObserver)
            verify(apiService, times(2)).getUserProfile(username)
            viewModel.userProfile.removeObserver(apiUsersProfileObserver)
        }
    }

    @Test
    fun fetchNull() {
        try {
            testCoroutineRule.runBlockingTest {
                val response: Response<*> = apiService.getUserProfile("anchitkm")
                Assert.assertEquals(response?.code(), null)

            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    @Test
    fun fetchSuccess() {
        try {
            testCoroutineRule.runBlockingTest {
                val response: Response<*> = apiService.getUserProfile("anchitkm")
                delay(10000)
                Assert.assertEquals(response?.code(), 200)

            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}