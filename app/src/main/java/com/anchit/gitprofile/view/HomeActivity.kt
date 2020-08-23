package com.anchit.gitprofile.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anchit.gitprofile.R
import com.anchit.gitprofile.databinding.ActivityHomeBinding
import com.anchit.gitprofile.viewmodel.GitViewModel
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {

    companion object {
        private val TAG = HomeActivity::class.java.simpleName
    }

    private var binding: ActivityHomeBinding? = null
    private var viewModel: GitViewModel? = null
    private var userName: String? = null
    private val adapter = ReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding?.lifecycleOwner = this
        initViewModel()

    }

    private fun initViewModel() {

        binding?.etSearchBar
        binding?.etSearchBar?.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding?.etSearchBar?.clearFocus()
                val `in`: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                `in`.hideSoftInputFromWindow(binding?.etSearchBar?.windowToken, 0)
                userName = binding?.etSearchBar?.text?.trim().toString()
                viewModel = ViewModelProvider(this).get(GitViewModel::class.java)
                if (userName.isNullOrEmpty()) {
                    binding?.etSearchBar?.error = getString(R.string.invalid_input)
                } else {
                    binding?.progressCircular?.visibility = View.VISIBLE
                    binding?.userContainer?.visibility = View.GONE
                    fetchUserProfile()
                }
                return@OnEditorActionListener true
            }
            false
        })

    }

    private fun fetchUserProfile() {

        binding?.rvRepoList?.adapter = adapter
        CoroutineScope(Dispatchers.IO).launch {
            viewModel?.fetchUserInfo(userName ?: "")
        }
        viewModel?.userInfoLiveData?.observe(this, Observer {
            val profile = it.profile
            val repos = it.repos
            if (profile?.name.isNullOrEmpty()) {
                binding?.tvUserFullName?.visibility = View.GONE
            } else {
                binding?.tvUserFullName?.text = profile?.name
            }
            if (profile?.login.isNullOrEmpty()) {
                binding?.tvUsername?.visibility = View.GONE
            } else {
                binding?.tvUsername?.text = profile?.login
            }
            if (profile?.location.isNullOrEmpty()) {
                binding?.tvLocation?.visibility = View.GONE
            } else {
                binding?.tvLocation?.text = profile?.location
            }
            if (profile?.htmlUrl.isNullOrEmpty()) {
                binding?.tvProfileUrl?.visibility = View.GONE
            } else {
                binding?.tvProfileUrl?.setOnClickListener {
                    profile?.htmlUrl?.let { url ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(intent)
                    }
                }
                binding?.tvProfileUrl?.text = profile?.htmlUrl
            }
            binding?.civProfilePicture?.let { it1 ->
                Glide.with(this).load(profile?.avatarUrl).circleCrop().into(
                    it1
                )
            }
            binding?.tvRepoCount?.text =
                this.getString(R.string.public_repositories, repos.size.toString())
            showEmptyList(repos.isEmpty())
            adapter.submitList(repos)
            binding?.progressCircular?.visibility = View.GONE
            binding?.userContainer?.visibility = View.VISIBLE

        })

    }

    private fun showEmptyList(show: Boolean) {
        if (show) {
            binding?.emptyList?.visibility = View.VISIBLE
            binding?.rvRepoList?.visibility = View.GONE
        } else {
            binding?.emptyList?.visibility = View.GONE
            binding?.rvRepoList?.visibility = View.VISIBLE
        }
    }

    /*private fun initAdapter() {
        binding?.rvRepoList?.adapter = adapter
        viewModel.repos.observe(this, Observer<List<User>> {
            Log.d("Activity", "list: ${it?.size}")
            showEmptyList(it?.size == 0)
            adapter.submitList(it)
        })
        viewModel.networkErrors.observe(this, Observer<String> {
            Toast.makeText(this, "\uD83D\uDE28 Wooops $it", Toast.LENGTH_LONG).show()
        })
    }*/

}