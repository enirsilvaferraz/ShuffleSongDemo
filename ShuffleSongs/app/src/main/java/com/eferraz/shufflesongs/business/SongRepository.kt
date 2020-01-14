package com.eferraz.shufflesongs.business

import com.eferraz.shufflesongs.data.Song

interface SongRepository {

    suspend fun getSongs(): List<Song>
}
