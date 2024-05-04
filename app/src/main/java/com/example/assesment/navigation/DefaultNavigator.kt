package com.example.assesment.navigation

import com.example.presentation.DetailsActivity
import com.example.presentation.ListingActivity
import com.example.utils.Activities
import com.example.utils.Navigator

class DefaultNavigator : Navigator.Provider {
    override fun getActivities(activities: Activities): Navigator {
        return when(activities){
            Activities.ListingActivity->{
                ListingActivity.GoToListingActivity
            }
            Activities.DetailsActivity->{
                DetailsActivity.GoToDetailsActivity
            }
        }
    }
}