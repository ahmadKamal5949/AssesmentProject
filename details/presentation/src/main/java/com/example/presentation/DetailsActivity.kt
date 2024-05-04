package com.example.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.details_presentation.databinding.ActivityDetailsBinding
import com.example.utils.Navigator

class DetailsActivity : AppCompatActivity() {

    companion object{
        fun launch(activity: Activity ){
            val intent = Intent(activity, DetailsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private var _binding: ActivityDetailsBinding? = null
    private val binding: ActivityDetailsBinding
        get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    object GoToDetailsActivity : Navigator{
        override fun navigate(activity: Activity) {
            launch(activity)
        }

    }
}