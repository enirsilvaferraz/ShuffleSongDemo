package com.eferraz.shufflesongs.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "artistId") val artistId: Int?,
    @ColumnInfo(name = "wrapperType") val wrapperType: String,
    @ColumnInfo(name = "artistName") val artistName: String,
    @ColumnInfo(name = "trackName") val trackName: String,
    @ColumnInfo(name = "artworkUrl") val artworkUrl: String
)


