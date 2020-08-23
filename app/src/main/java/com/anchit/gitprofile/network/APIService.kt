package com.anchit.gitprofile.network

import com.anchit.gitprofile.model.UserProfile
import com.anchit.gitprofile.model.UserRepos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface APIService {

    @GET("users/{userName}")
    suspend fun getUserProfile(@Path("userName") user: String): Response<UserProfile>

    @GET("users/{query}/repos")
    suspend fun getUserRepo(
        @Path("query") user: String
    ): Response<UserRepos>
}