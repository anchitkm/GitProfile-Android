package com.anchit.gitprofile.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

class UserRepos : ArrayList<UserRepos.UserReposItem>(){
    @Keep
    data class UserReposItem(
        @SerializedName("archive_url")
        val archiveUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/{archive_format}{/ref}
        @SerializedName("archived")
        val archived: Boolean = false, // false
        @SerializedName("assignees_url")
        val assigneesUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/assignees{/user}
        @SerializedName("blobs_url")
        val blobsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/git/blobs{/sha}
        @SerializedName("branches_url")
        val branchesUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/branches{/branch}
        @SerializedName("clone_url")
        val cloneUrl: String = "", // https://github.com/anchitkm/ud851-Exercises.git
        @SerializedName("collaborators_url")
        val collaboratorsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/collaborators{/collaborator}
        @SerializedName("comments_url")
        val commentsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/comments{/number}
        @SerializedName("commits_url")
        val commitsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/commits{/sha}
        @SerializedName("compare_url")
        val compareUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/compare/{base}...{head}
        @SerializedName("contents_url")
        val contentsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/contents/{+path}
        @SerializedName("contributors_url")
        val contributorsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/contributors
        @SerializedName("created_at")
        val createdAt: String = "", // 2018-05-09T13:59:46Z
        @SerializedName("default_branch")
        val defaultBranch: String = "", // student
        @SerializedName("deployments_url")
        val deploymentsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/deployments
        @SerializedName("description")
        val description: String? = null, // Source code for the course: Spring and Hibernate for Beginners
        @SerializedName("disabled")
        val disabled: Boolean = false, // false
        @SerializedName("downloads_url")
        val downloadsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/downloads
        @SerializedName("events_url")
        val eventsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/events
        @SerializedName("fork")
        val fork: Boolean = false, // true
        @SerializedName("forks")
        val forks: Int = 0, // 0
        @SerializedName("forks_count")
        val forksCount: Int = 0, // 0
        @SerializedName("forks_url")
        val forksUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/forks
        @SerializedName("full_name")
        val fullName: String = "", // anchitkm/ud851-Exercises
        @SerializedName("git_commits_url")
        val gitCommitsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/git/commits{/sha}
        @SerializedName("git_refs_url")
        val gitRefsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/git/refs{/sha}
        @SerializedName("git_tags_url")
        val gitTagsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/git/tags{/sha}
        @SerializedName("git_url")
        val gitUrl: String = "", // git://github.com/anchitkm/ud851-Exercises.git
        @SerializedName("has_downloads")
        val hasDownloads: Boolean = false, // true
        @SerializedName("has_issues")
        val hasIssues: Boolean = false, // false
        @SerializedName("has_pages")
        val hasPages: Boolean = false, // false
        @SerializedName("has_projects")
        val hasProjects: Boolean = false, // true
        @SerializedName("has_wiki")
        val hasWiki: Boolean = false, // true
        @SerializedName("homepage")
        val homepage: String? = null,
        @SerializedName("hooks_url")
        val hooksUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/hooks
        @SerializedName("html_url")
        val htmlUrl: String = "", // https://github.com/anchitkm/ud851-Exercises
        @SerializedName("id")
        val id: Int = 0, // 132765066
        @SerializedName("issue_comment_url")
        val issueCommentUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/issues/comments{/number}
        @SerializedName("issue_events_url")
        val issueEventsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/issues/events{/number}
        @SerializedName("issues_url")
        val issuesUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/issues{/number}
        @SerializedName("keys_url")
        val keysUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/keys{/key_id}
        @SerializedName("labels_url")
        val labelsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/labels{/name}
        @SerializedName("language")
        val language: String? = null, // Java
        @SerializedName("languages_url")
        val languagesUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/languages
        @SerializedName("license")
        val license: License? = null,
        @SerializedName("merges_url")
        val mergesUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/merges
        @SerializedName("milestones_url")
        val milestonesUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/milestones{/number}
        @SerializedName("mirror_url")
        val mirrorUrl: Any? = null, // null
        @SerializedName("name")
        val name: String = "", // ud851-Exercises
        @SerializedName("node_id")
        val nodeId: String = "", // MDEwOlJlcG9zaXRvcnkxMzI3NjUwNjY=
        @SerializedName("notifications_url")
        val notificationsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/notifications{?since,all,participating}
        @SerializedName("open_issues")
        val openIssues: Int = 0, // 0
        @SerializedName("open_issues_count")
        val openIssuesCount: Int = 0, // 0
        @SerializedName("owner")
        val owner: Owner = Owner(),
        @SerializedName("private")
        val `private`: Boolean = false, // false
        @SerializedName("pulls_url")
        val pullsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/pulls{/number}
        @SerializedName("pushed_at")
        val pushedAt: String = "", // 2018-05-08T11:21:18Z
        @SerializedName("releases_url")
        val releasesUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/releases{/id}
        @SerializedName("size")
        val size: Int = 0, // 3989
        @SerializedName("ssh_url")
        val sshUrl: String = "", // git@github.com:anchitkm/ud851-Exercises.git
        @SerializedName("stargazers_count")
        val stargazersCount: Int = 0, // 0
        @SerializedName("stargazers_url")
        val stargazersUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/stargazers
        @SerializedName("statuses_url")
        val statusesUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/statuses/{sha}
        @SerializedName("subscribers_url")
        val subscribersUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/subscribers
        @SerializedName("subscription_url")
        val subscriptionUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/subscription
        @SerializedName("svn_url")
        val svnUrl: String = "", // https://github.com/anchitkm/ud851-Exercises
        @SerializedName("tags_url")
        val tagsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/tags
        @SerializedName("teams_url")
        val teamsUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/teams
        @SerializedName("trees_url")
        val treesUrl: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises/git/trees{/sha}
        @SerializedName("updated_at")
        val updatedAt: String = "", // 2018-05-09T13:59:58Z
        @SerializedName("url")
        val url: String = "", // https://api.github.com/repos/anchitkm/ud851-Exercises
        @SerializedName("watchers")
        val watchers: Int = 0, // 0
        @SerializedName("watchers_count")
        val watchersCount: Int = 0 // 0
    ) {
        @Keep
        data class License(
            @SerializedName("key")
            val key: String = "", // apache-2.0
            @SerializedName("name")
            val name: String = "", // Apache License 2.0
            @SerializedName("node_id")
            val nodeId: String = "", // MDc6TGljZW5zZTI=
            @SerializedName("spdx_id")
            val spdxId: String = "", // Apache-2.0
            @SerializedName("url")
            val url: String = "" // https://api.github.com/licenses/apache-2.0
        )
    
        @Keep
        data class Owner(
            @SerializedName("avatar_url")
            val avatarUrl: String = "", // https://avatars2.githubusercontent.com/u/13197643?v=4
            @SerializedName("events_url")
            val eventsUrl: String = "", // https://api.github.com/users/anchitkm/events{/privacy}
            @SerializedName("followers_url")
            val followersUrl: String = "", // https://api.github.com/users/anchitkm/followers
            @SerializedName("following_url")
            val followingUrl: String = "", // https://api.github.com/users/anchitkm/following{/other_user}
            @SerializedName("gists_url")
            val gistsUrl: String = "", // https://api.github.com/users/anchitkm/gists{/gist_id}
            @SerializedName("gravatar_id")
            val gravatarId: String = "",
            @SerializedName("html_url")
            val htmlUrl: String = "", // https://github.com/anchitkm
            @SerializedName("id")
            val id: Int = 0, // 13197643
            @SerializedName("login")
            val login: String = "", // anchitkm
            @SerializedName("node_id")
            val nodeId: String = "", // MDQ6VXNlcjEzMTk3NjQz
            @SerializedName("organizations_url")
            val organizationsUrl: String = "", // https://api.github.com/users/anchitkm/orgs
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
            @SerializedName("type")
            val type: String = "", // User
            @SerializedName("url")
            val url: String = "" // https://api.github.com/users/anchitkm
        )
    }
}