package com.anchit.gitprofile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anchit.gitprofile.model.UserInfo
import com.anchit.gitprofile.model.UserProfile
import com.anchit.gitprofile.model.UserRepos
import com.anchit.gitprofile.repo.GitProfileRepository

open class GitViewModel : ViewModel() {

    companion object {
        private val TAG = GitViewModel::class.java.simpleName
    }

    public var userProfile = MutableLiveData<UserProfile>()
    var userRepo = MutableLiveData<UserRepos>()
    var progressBar = MutableLiveData<Boolean>()
    var combinedResult = MediatorLiveData<UserInfo>()


//    val results=userProfile.combineWith(userRepo){
//        userProfile, userRepos ->
//
//        val userInfo=UserInfo(userProfile!!,userRepos!!)
//        combinedResult.postValue(userInfo)
//    }


    private fun <T, K, R> LiveData<T>.combineWith(
        liveData: LiveData<K>,
        block: (T?, K?) -> R
    ): LiveData<R> {
        val result = MediatorLiveData<R>()
        result.addSource(this) {
            result.value = block(this.value, liveData.value)
        }
        result.addSource(liveData) {
            result.value = block(this.value, liveData.value)
        }
        return result
    }
    fun getUserProfile(userName:String) {

        progressBar.postValue(true)
        GitProfileRepository.userProfile.observeForever {
            progressBar.postValue(false)
            userProfile.postValue(it)

        }
        GitProfileRepository.getUserProfile(userName)
    }

    fun getUserRepo(userName:String){

//        progressBar.postValue(true)
        GitProfileRepository.userRepos.observeForever {
//            progressBar.postValue(false)
            userRepo.postValue(it)
        }
        GitProfileRepository.getUserRepos(userName)
    }
    override fun onCleared() {
        super.onCleared()
        GitProfileRepository.userProfile.removeObserver { it }
        GitProfileRepository.userRepos.removeObserver{ it }
    }

}