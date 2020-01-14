package com.eferraz.shufflesongs.business

import com.eferraz.shufflesongs.data.AppDataBase
import com.eferraz.shufflesongs.data.Song

class SongRepositoryLocalImpl(private val db: AppDataBase) : SongRepository {

    override suspend fun getSongs() = db.songDao().getAll()

    suspend fun update(media: List<Song>) {
        db.songDao().update(media)
    }

}
