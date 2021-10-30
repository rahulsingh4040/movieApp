package com.example.contacts.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(contact: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovies(contact: List<MovieEntity>)

    @Query("SELECT * FROM movieTable WHERE id = :id")
    fun getMovie(id: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM movieTable")
    fun getAllMovies(): LiveData<List<MovieEntity>>

}