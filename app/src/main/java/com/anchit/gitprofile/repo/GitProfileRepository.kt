package com.anchit.gitprofile.repo

import androidx.lifecycle.MutableLiveData
import com.anchit.gitprofile.model.UserProfile
import com.anchit.gitprofile.model.UserRepos
import com.anchit.gitprofile.network.APIService
import com.anchit.gitprofile.network.APIServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GitProfileRepository {

    var error: MutableLiveData<Boolean> = MutableLiveData()
    var userProfile = MutableLiveData<UserProfile>()
    var userRepos = MutableLiveData<UserRepos>()
    private fun getApi(): APIService {

        return APIServiceBuilder.buildService(APIService::class.java)
    }


    fun getUserProfile(userName: String) {
        val response = getApi().getUserProfile(userName)

        response.enqueue(object : Callback<UserProfile> {
            override fun onFailure(call: Call<UserProfile>, t: Throwable) {
                error.value = true
            }

            override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {
                if (response.isSuccessful) {
                    val userProfileResponse = response.body()
                    userProfile.value = userProfileResponse


                } else {
                    error.value = true
                }

            }
        })
    }
    fun getUserRepos(userName: String) {
        val response = getApi().getUserRepo(userName)

        response.enqueue(object : Callback<UserRepos> {
            override fun onFailure(call: Call<UserRepos>, t: Throwable) {
                error.value = true
            }

            override fun onResponse(call: Call<UserRepos>, response: Response<UserRepos>) {
                if (response.isSuccessful) {
                    val userProfileResponse = response.body()
                    userRepos.value = userProfileResponse

                } else {
                    error.value = true
                }

            }
        })
    }
}