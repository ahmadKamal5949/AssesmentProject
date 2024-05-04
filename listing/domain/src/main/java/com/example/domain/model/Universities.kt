package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.io.Serializable

@Entity
data class Universities(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    @PrimaryKey(autoGenerate = false)
    val name: String = "",
    val state: String,
    val web_pages: List<String>
): Serializable
