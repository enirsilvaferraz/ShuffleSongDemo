package com.eferraz.shufflesongs.business

import com.eferraz.shufflesongs.data.Song

class ShuffleBusinessMock : ShuffleBusiness {

    override suspend fun getSongs(): List<Song> =  listOf(
        Song(id = 2, artistId = 1, wrapperType = "track", artistName = "Artist 1", trackName = "Track 2", artworkUrl = "https://firebasestorage.googleapis.com/v0/b/tw-exercicio-mobile.appspot.com/o/albums%2Fjohn-dollar-antihero.png?alt=media&token=68b89bd6-87c4-4122-9998-dbd33f75f90c"),
        Song(id = 5, artistId = 3, wrapperType = "track", artistName = "Artist 3", trackName = "Track 5", artworkUrl = "https://firebasestorage.googleapis.com/v0/b/tw-exercicio-mobile.appspot.com/o/albums%2Fjohn-dollar-antihero.png?alt=media&token=68b89bd6-87c4-4122-9998-dbd33f75f90c"),
        Song(id = 3, artistId = 2, wrapperType = "track", artistName = "Artist 2", trackName = "Track 3", artworkUrl = "https://firebasestorage.googleapis.com/v0/b/tw-exercicio-mobile.appspot.com/o/albums%2Fjohn-dollar-antihero.png?alt=media&token=68b89bd6-87c4-4122-9998-dbd33f75f90c"),
        Song(id = 6, artistId = 3, wrapperType = "track", artistName = "Artist 3", trackName = "Track 6", artworkUrl = "https://firebasestorage.googleapis.com/v0/b/tw-exercicio-mobile.appspot.com/o/albums%2Fjohn-dollar-antihero.png?alt=media&token=68b89bd6-87c4-4122-9998-dbd33f75f90c"),
        Song(id = 1, artistId = 1, wrapperType = "track", artistName = "Artist 1", trackName = "Track 1", artworkUrl = "https://firebasestorage.googleapis.com/v0/b/tw-exercicio-mobile.appspot.com/o/albums%2Fjohn-dollar-antihero.png?alt=media&token=68b89bd6-87c4-4122-9998-dbd33f75f90c"),
        Song(id = 4, artistId = 2, wrapperType = "track", artistName = "Artist 2", trackName = "Track 4", artworkUrl = "https://firebasestorage.googleapis.com/v0/b/tw-exercicio-mobile.appspot.com/o/albums%2Fjohn-dollar-antihero.png?alt=media&token=68b89bd6-87c4-4122-9998-dbd33f75f90c")
    )
}
