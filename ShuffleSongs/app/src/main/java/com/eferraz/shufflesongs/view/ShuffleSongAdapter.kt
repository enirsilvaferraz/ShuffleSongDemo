package com.eferraz.shufflesongs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eferraz.shufflesongs.R
import com.eferraz.shufflesongs.data.Song
import com.eferraz.shufflesongs.infra.load
import kotlinx.android.synthetic.main.item_song.view.*

class ShuffleSongAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: ArrayList<Song> by lazy { arrayListOf<Song>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        SongViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_song,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SongViewHolder).bind(list[position])
    }

    fun update(list: List<Song>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(song: Song) {
            itemView.albumImage.load(song.artworkUrl)
            itemView.artistName.text = song.artistName
            itemView.songName.text = song.trackName
        }
    }

}

