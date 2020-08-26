package com.anchit.gitprofile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anchit.gitprofile.model.UserInfo
import com.anchit.gitprofile.model.UserProfile
import com.anchit.gitprofile.model.UserRepos
import com.anchit.gitprofile.repo.GitProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class GitViewModel : ViewModel() {

    companion object {
        private val TAG = GitViewModel::class.java.simpleName
    }

    var userInfoLiveData = MutableLiveData<UserInfo>()
    var userProfile=MutableLiveData<UserProfile>()
    var userRepos=MutableLiveData<UserRepos>()

    suspend fun fetchUserInfo(userName: String)= withContext(Dispatchers.IO){

        val userProfile=
            async {
                return@async GitProfileRepository.getUserProfile(userName)
            }
        val userRepos=
            async {
                return@async GitProfileRepository.getUserRepos(userName)
            }

        val userInfo= UserInfo(userProfile.await(), (userRepos.await()!!))
        userInfoLiveData.postValue(userInfo)
    }

}