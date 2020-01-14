package com.eferraz.shufflesongs.business

import com.eferraz.shufflesongs.business.ConfigurationConstants.WRAPPER_TYPE_TRACK
import com.eferraz.shufflesongs.data.Song
import com.eferraz.shufflesongs.infra.NetworkUtil


class ShuffleBusinessImpl(
    private val remoteRep: SongRepositoryRemoteImpl,
    private val localRep: SongRepositoryLocalImpl,
    private val network: NetworkUtil
) : ShuffleBusiness {

    override suspend fun getSongs(): List<Song> {

        val media = if (network.isNetworkAvailable()) remoteRep.getSongs() else localRep.getSongs()

        val songs = media.filter { it.wrapperType == WRAPPER_TYPE_TRACK }

        localRep.update(songs)

        return if (songs.isNotEmpty()) randomize(songs.toMutableList()) else emptyList()
    }

    private fun randomize(fetched: MutableList<Song>): ArrayList<Song> {

        val shuffled = arrayListOf<Song>()

        val first = fetched.shuffled().first()
        shuffled.add(first)
        fetched.remove(first)

        fetched.forEach {
            if (!shuffled.contains(it) && allowAdd(it, shuffled.last())) {
                shuffled.add(it)
            }
        }

        fetched.removeAll(shuffled)

        fetched.forEach {

            for (index in 1 until shuffled.size) {

                val previous = shuffled[index - 1]
                val current = shuffled[index]

                if (allowAdd(previous, it) && allowAdd(current, it)) {
                    shuffled.add(index, it)
                    break
                }
            }
        }

        return shuffled
    }

    private fun allowAdd(
        current: Song,
        it: Song
    ) = current.artistId != it.artistId
}

