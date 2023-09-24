package com.accidentaldeveloper.hilt.repository

import com.accidentaldeveloper.hilt.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val apiService: ApiService){
    suspend fun getTvShows() = apiService.getTvShows()
}