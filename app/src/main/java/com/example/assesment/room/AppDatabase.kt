package com.example.assesment.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.domain.model.Universities
import com.example.listing_data.room.ListingDAO

@Database(entities = [Universities::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase(){
    companion object{
        fun getInstance(context : Context): AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build()
        }
    }
    abstract fun getListingDao() : ListingDAO
}