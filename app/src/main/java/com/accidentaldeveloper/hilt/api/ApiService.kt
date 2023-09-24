package com.accidentaldeveloper.hilt.api

import com.accidentaldeveloper.hilt.Models.TvShowResponse
import com.accidentaldeveloper.hilt.utils.AppConstant
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(AppConstant.END_POINT)
    suspend fun getTvShows():Response<TvShowResponse>
}