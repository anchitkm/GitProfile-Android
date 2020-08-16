package com.anchit.gitprofile.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class UserProfile(
    @SerializedName("avatar_url")
    val avatarUrl: String = "", // https://avatars2.githubusercontent.com/u/13197643?v=4
    @SerializedName("bio")
    val bio: String = "", // Technology Enthusiast | Learner | Java | Kotlin | Solution Provider
    @SerializedName("blog")
    val blog: String = "", // https://medium.com/@anchitkm
    @SerializedName("company")
    val company: String = "", // GlobalLogic
    @SerializedName("created_at")
    val createdAt: String = "", // 2015-07-06T09:23:44Z
    @SerializedName("email")
    val email: String? = null, // null
    @SerializedName("events_url")
    val eventsUrl: String = "", // https://api.github.com/users/anchitkm/events{/privacy}
    @SerializedName("followers")
    val followers: Int = 0, // 1
    @SerializedName("followers_url")
    val followersUrl: String = "", // https://api.github.com/users/anchitkm/followers
    @SerializedName("following")
    val following: Int = 0, // 9
    @SerializedName("following_url")
    val followingUrl: String = "", // https://api.github.com/users/anchitkm/following{/other_user}
    @SerializedName("gists_url")
    val gistsUrl: String = "", // https://api.github.com/users/anchitkm/gists{/gist_id}
    @SerializedName("gravatar_id")
    val gravatarId: String = "",
    @SerializedName("hireable")
    val hireable: Any? = null, // null
    @SerializedName("html_url")
    val htmlUrl: String = "", // https://github.com/anchitkm
    @SerializedName("id")
    val id: Int = 0, // 13197643
    @SerializedName("location")
    val location: String = "", // Noida
    @SerializedName("login")
    val login: String = "", // anchitkm
    @SerializedName("name")
    val name: String? = null, // null
    @SerializedName("node_id")
    val nodeId: String = "", // MDQ6VXNlcjEzMTk3NjQz
    @SerializedName("organizations_url")
    val organizationsUrl: String = "", // https://api.github.com/users/anchitkm/orgs
    @SerializedName("public_gists")
    val publicGists: Int = 0, // 0
    @SerializedName("public_repos")
    val publicRepos: Int = 0, // 9
    @SerializedName("received_events_url")
    val receivedEventsUrl: String = "", // https://api.github.com/users/anchitkm/received_events
    @SerializedName("repos_url")
    val reposUrl: String = "", // https://api.github.com/users/anchitkm/repos
    @SerializedName("site_admin")
    val siteAdmin: Boolean = false, // false
    @SerializedName("starred_url")
    val starredUrl: String = "", // https://api.github.com/users/anchitkm/starred{/owner}{/repo}
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String = "", // https://api.github.com/users/anchitkm/subscriptions
    @SerializedName("twitter_username")
    val twitterUsername: Any? = null, // null
    @SerializedName("type")
    val type: String = "", // User
    @SerializedName("updated_at")
    val updatedAt: String = "", // 2020-08-16T10:31:40Z
    @SerializedName("url")
    val url: String = "" // https://api.github.com/users/anchitkm
)