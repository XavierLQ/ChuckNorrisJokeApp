package com.example.chucknorrisjokeapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "JokeItemTable")
data class JokeItem(

    @PrimaryKey
    @ColumnInfo
    @SerializedName("id")
    val id: Int,

    @ColumnInfo
    @SerializedName("categories")
    val categories: List<Any>,

    @ColumnInfo
    @SerializedName("joke")
    val joke: String
)