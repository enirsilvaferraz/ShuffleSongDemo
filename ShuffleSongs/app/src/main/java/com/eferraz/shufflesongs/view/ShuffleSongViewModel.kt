package com.eferraz.shufflesongs.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eferraz.shufflesongs.business.ShuffleBusiness
import com.eferraz.shufflesongs.data.Song
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ShuffleSongViewModel(private val business: ShuffleBusiness) : ViewModel() {

    val songs: MutableLiveData<List<Song>> = MutableLiveData(listOf())

    fun onSwipeToRefresh() {
        loadData()
    }

    fun start() {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Main) {
            songs.postValue(business.getSongs())
        }
    }
}
