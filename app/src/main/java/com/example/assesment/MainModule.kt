package com.example.assesment

import android.content.Context
import com.example.assesment.navigation.DefaultNavigator
import com.example.assesment.room.AppDatabase
import com.example.listing_data.room.ListingDAO
import com.example.utils.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainModule {

    @Provides
    @Singleton
    fun provideProvider():Navigator.Provider{
        return DefaultNavigator()
    }

    @Provides
    @Singleton
    fun provideListingDatabase(@ApplicationContext context: Context) : AppDatabase{
        return AppDatabase.getInstance(context)
    }
    @Provides
    fun provideListingDao(appDatabase: AppDatabase) : ListingDAO{
        return appDatabase.getListingDao()
    }
}