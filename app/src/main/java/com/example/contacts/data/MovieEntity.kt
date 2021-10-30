package com.example.contacts.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieTable")
data class MovieEntity(
    @PrimaryKey
    var id: Int,
    var title: String,
    var releaseDate: String,
    var overview: String,
    var popularity: String,
    var rating: String
) {
    constructor(title: String, releaseDate: String, overview: String, popularity: String, rating: String) : this(0, title, releaseDate, overview, popularity, rating)
}