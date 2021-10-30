package com.example.contacts.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val database = MovieDatabase.getInstance(app)

    val contactsList = database?.movieDao()?.getAllMovies()

    fun addSampleData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val sampleData = DumyDataGenerator.getMovies()
                database?.movieDao()?.insertAllMovies(sampleData)
            }
        }
    }
}