package com.example.assesment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utils.Activities
import com.example.utils.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var provider: Navigator.Provider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        provider.getActivities(Activities.ListingActivity).navigate(this)
    }
}