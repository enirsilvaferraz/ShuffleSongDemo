package com.eferraz.shufflesongs.business

import com.eferraz.shufflesongs.data.Song

interface ShuffleBusiness {

    suspend fun getSongs(): List<Song>
}
