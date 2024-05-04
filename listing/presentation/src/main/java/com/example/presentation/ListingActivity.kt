package com.example.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.presentation.databinding.ActivityListingBinding
import com.example.utils.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class ListingActivity : AppCompatActivity() {

    @Inject
    lateinit var provider: Navigator.Provider

    companion object {
        fun launch(activity: Activity){
            val intent = Intent(activity, ListingActivity::class.java)
            activity.startActivity(intent)
        }
    }
    private var _binding: ActivityListingBinding? = null
    private val binding: ActivityListingBinding
        get() = _binding!!
    private val viewModel : ListingViewModel by viewModels()
    private val adapter = ListingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setObservers()
    }
    private fun initView() {
        binding.rvUniList.adapter = adapter
    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.listUniversities.collectLatest {
                if (it.isLoading) {
                    binding.progressBar.visibility= View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility= View.GONE
                    Toast.makeText(this@ListingActivity, it.error, Toast.LENGTH_LONG).show()
                }
                it.data?.let {
                    binding.progressBar.visibility= View.GONE
                    adapter.setData(it, this@ListingActivity, provider)
                }
            }
        }

    }

    object GoToListingActivity : Navigator{
        override fun navigate(activity: Activity) {
            launch(activity)
        }

    }
}