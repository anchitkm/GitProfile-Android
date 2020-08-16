package com.anchit.gitprofile.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anchit.gitprofile.R
import com.anchit.gitprofile.databinding.ItemGitProfileBinding
import com.anchit.gitprofile.viewmodel.GitViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_git_profile.view.*


class HomeActivity : AppCompatActivity() {

    companion object {
        private val TAG = HomeActivity::class.java.simpleName
    }

    private var binding: ItemGitProfileBinding? = null
    private var viewModel: GitViewModel? = null
    private var userName: String = "anchitkm"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.item_git_profile)
        binding?.lifecycleOwner=this
        initViewModel()

    }

    private fun initViewModel() {

//        binding?.root?.progressBar?.visibility = View.VISIBLE
        binding?.root?.ib_search?.setOnClickListener {
            binding?.root?.et_search_bar?.visibility = View.VISIBLE
        }

        binding?.root?.et_search_bar?.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding?.root?.et_search_bar?.clearFocus()
                val `in`: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                `in`.hideSoftInputFromWindow(binding?.root?.et_search_bar?.windowToken, 0)
                binding?.root?.et_search_bar?.visibility=View.GONE
                userName = binding?.root?.et_search_bar?.text?.trim().toString()
                viewModel = ViewModelProvider(this).get(GitViewModel::class.java)
                fetchUserProfile()
                fetchUserRepo()
                return@OnEditorActionListener true
            }
            false
        })

    }


    /* viewModel?.progressBar?.observe(this, Observer {
         if (!it) {
             binding?.root?.progressBar?.visibility = View.GONE
         } else {
             binding?.root?.progressBar?.visibility = View.VISIBLE
         }
     })*/


    /* viewModel?.result?.observe(this, Observer {
         Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()
     })*/

    /*  viewModel?.combinedResult?.observe(this, Observer {
          Log.e(TAG, "Size"+it.repos.size + "C Name"+it.profile.company)
      })*/


private fun fetchUserProfile() {

    viewModel?.getUserProfile(userName)
    viewModel?.userProfile?.observe(this, Observer {
        binding?.tvUserFullName?.text=it.name?:""
        binding?.tvUsername?.text=it.login?:""
        binding?.tvLocation?.text=it.location?:""
        binding?.tvProfileUrl?.text=it.htmlUrl?:""
        binding?.tvMail?.text=it.email?:""
        binding?.civProfilePicture?.let { it1 ->
            Glide.with(this).load(it.avatarUrl).circleCrop().into(
                it1
            )
        }

    })
}

private fun fetchUserRepo() {
    viewModel?.getUserRepo(userName)

    viewModel?.userRepo?.observe(this, Observer {
        Log.e(TAG, "" + it.size)
    })
}
}