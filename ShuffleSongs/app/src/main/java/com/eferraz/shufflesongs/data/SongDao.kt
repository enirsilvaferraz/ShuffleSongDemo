package com.eferraz.shufflesongs.data

import androidx.room.*

@Dao
interface SongDao {

    @Query("SELECT * FROM song")
    suspend fun getAll(): List<Song>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(songs: List<Song>)

    @Delete
    suspend fun delete(song: Song)
}
