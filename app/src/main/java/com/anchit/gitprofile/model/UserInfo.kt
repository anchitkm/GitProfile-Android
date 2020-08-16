package com.anchit.gitprofile.model

import androidx.annotation.Keep

@Keep
data class UserInfo(val profile: UserProfile,val repos: UserRepos)
