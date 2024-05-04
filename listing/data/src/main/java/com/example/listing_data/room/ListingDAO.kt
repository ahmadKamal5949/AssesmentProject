package com.example.listing_data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.Universities

@Dao
interface ListingDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertList(list:List<Universities>)


    @Query("SELECT * FROM Universities")
     fun getNewsArticle():List<Universities>


}