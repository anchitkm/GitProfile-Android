

package com.anchit.gitprofile.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.anchit.gitprofile.model.UserRepos

/**
 * Adapter for the list of repositories.
 */
class ReposAdapter : ListAdapter<UserRepos.UserReposItem, androidx.recyclerview.widget.RecyclerView.ViewHolder>(
    REPO_COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        return RepoViewHolder.create(
            parent
        )
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as RepoViewHolder).bind(repoItem)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<UserRepos.UserReposItem>() {
            override fun areContentsTheSame(oldItem: UserRepos.UserReposItem, newItem: UserRepos.UserReposItem): Boolean =
                    oldItem == newItem

            override fun areItemsTheSame(oldItem: UserRepos.UserReposItem, newItem: UserRepos.UserReposItem): Boolean =
                oldItem.id == newItem.id
        }
    }
}
