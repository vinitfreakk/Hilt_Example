package com.accidentaldeveloper.hilt.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accidentaldeveloper.hilt.Models.TvShowResponseItem
import com.accidentaldeveloper.hilt.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(private val repository: TvShowRepository):ViewModel(){
    private val _response = MutableLiveData<List<TvShowResponseItem>>()
    val responseTvShow:LiveData<List<TvShowResponseItem>> = _response

    init {
        getAllTvShow()
    }

    private fun getAllTvShow() = viewModelScope.launch{
        repository.getTvShows().let { response ->
           if(response.isSuccessful){
               _response.postValue(response.body())
           }else{
               Log.d("tag","getAllTvShows Error:${response.code()}")
           }
        }
    }

}