package com.eferraz.shufflesongs.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Song::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun songDao(): SongDao
}
