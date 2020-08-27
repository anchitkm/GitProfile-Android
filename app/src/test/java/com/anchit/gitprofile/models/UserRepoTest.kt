package com.anchit.gitprofile.models

import com.anchit.gitprofile.model.UserProfile
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserRepoTest {
    private val name: String = "Anchit mittal"
    private val userName: String = "anchitkm"
    private val url: String = "www.google.com"
    private val location: String="Noida"

    @Mock
    lateinit var userRepo: UserProfile


    @Before
    public fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`<Any>(userRepo.name)
            .thenReturn(name)
        Mockito.`when`<Any>(userRepo.login)
            .thenReturn(userName)
        Mockito.`when`<Any>(userRepo.htmlUrl)
            .thenReturn(url)
        Mockito.`when`<Any>(userRepo.location)
            .thenReturn(location)
    }

    @Test
    fun testName() {
        Mockito.`when`<Any>(userRepo.name).thenReturn(name)
        Assert.assertEquals("Anchit mittal", userRepo.name)
    }

    @Test
    fun testUserName() {
        Mockito.`when`<Any>(userRepo.login).thenReturn(userName)
        Assert.assertEquals("anchitkm", userRepo.login)
    }


    @Test
    fun testLocation() {
        Mockito.`when`<Any>(userRepo.location).thenReturn(location)
        Assert.assertEquals("Noida", userRepo.location)
    }

    @Test
    fun testURL() {
        Mockito.`when`<Any>(userRepo.url).thenReturn(url)
        Assert.assertEquals("www.google.com", userRepo.htmlUrl)
    }



}
