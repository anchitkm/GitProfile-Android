package com.anchit.gitprofile.network

import com.anchit.gitprofile.model.UserProfile
import com.anchit.gitprofile.model.UserRepos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface APIService {

    @GET("users/{userName}")
    fun getUserProfile(@Path("userName") user: String): Call<UserProfile>

    @GET("users/{query}/repos")
    fun getUserRepo(
        @Path("query") user: String
    ): Call<UserRepos>
}