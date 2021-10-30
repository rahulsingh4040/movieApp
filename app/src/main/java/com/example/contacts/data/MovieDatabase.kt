package com.example.contacts.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {


    abstract fun movieDao(): MovieDao?

    companion object {
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context) : MovieDatabase? {
            if (INSTANCE == null) {
                synchronized(MovieDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "movies.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}