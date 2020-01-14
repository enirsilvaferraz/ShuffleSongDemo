package com.eferraz.shufflesongs.business

import com.eferraz.shufflesongs.data.Song
import com.eferraz.shufflesongs.infra.NetworkUtil
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class ShuffleBusinessTest {

    private val remoteRep: SongRepositoryRemoteImpl = mockk()
    private val localRep: SongRepositoryLocalImpl = mockk()
    private val network: NetworkUtil = mockk()

    private val business: ShuffleBusinessImpl by lazy {
        spyk(ShuffleBusinessImpl(remoteRep = remoteRep, localRep = localRep, network = network))
    }

    @Test
    fun `Must consider only tracks on list`() = runBlocking {

        // Given
        val songs = listOf(
            Song(id = 1, artistId = null, wrapperType = "artist", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 2, artistId = 1, wrapperType = "track", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 3, artistId = 1, wrapperType = "track", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 4, artistId = null, wrapperType = "artist", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 5, artistId = 4, wrapperType = "track", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 6, artistId = null, wrapperType = "artist", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 7, artistId = 6, wrapperType = "track", artistName = "", trackName = "", artworkUrl = "")
        )

        coEvery { remoteRep.getSongs() } returns songs
        coEvery { localRep.getSongs() } returns songs
        coEvery { localRep.update(any()) } answers { nothing }
        every { network.isNetworkAvailable() } returns true

        // When
        val result = business.getSongs()

        // Then
        Assert.assertTrue(result.all { it.wrapperType == "track" })
    }

    @Test
    fun `Must choose the next song with different artist`() = runBlocking {

        // Given
        val songs = listOf(
            Song(id = 1, artistId = 1, wrapperType = "track", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 2, artistId = 1, wrapperType = "track", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 3, artistId = 2, wrapperType = "track", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 4, artistId = 2, wrapperType = "track", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 5, artistId = 3, wrapperType = "track", artistName = "", trackName = "", artworkUrl = ""),
            Song(id = 6, artistId = 3, wrapperType = "track", artistName = "", trackName = "", artworkUrl = "")
        )

        coEvery { remoteRep.getSongs() } returns songs
        coEvery { localRep.getSongs() } returns songs
        coEvery { localRep.update(any()) } answers { nothing }
        every { network.isNetworkAvailable() } returns true

        // When
        val result = business.getSongs()

        // Then
        for (index in 0 until songs.size-1) {
            Assert.assertNotEquals(result[index].artistId, result[index + 1].artistId)
        }
    }
}
