package com.anchit.gitprofile.repo

import com.anchit.gitprofile.model.UserProfile
import com.anchit.gitprofile.model.UserRepos
import com.anchit.gitprofile.network.APIService
import com.anchit.gitprofile.network.APIServiceBuilder

object GitProfileRepository {

    private fun getApi(): APIService {

        return APIServiceBuilder.buildService(APIService::class.java)
    }

    suspend fun getUserProfile(userName: String): UserProfile? {

        val response = getApi().getUserProfile(userName)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend fun getUserRepos(userName: String): UserRepos? {
        val response = getApi().getUserRepo(userName)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

}