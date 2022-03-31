package com.example.chucknorrisjokeapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import retrofit2.Converter

//@Entity(tableName = "JokeItemTable")
@TypeConverters(Converter::class)
data class JokeItem(
//    @PrimaryKey
//    @ColumnInfo
    @SerializedName("id")
    val id: Int,

//    @ColumnInfo
    @SerializedName("categories")
    val categories: List<String>,

//    @ColumnInfo
    @SerializedName("joke")
    val joke: String?
)