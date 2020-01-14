package com.eferraz.shufflesongs.view

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.eferraz.shufflesongs.R
import kotlinx.android.synthetic.main.activity_shuffle.*
import org.koin.android.viewmodel.ext.android.viewModel

class ShuffleActivity : AppCompatActivity() {

    private val viewModel: ShuffleSongViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shuffle)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ShuffleSongAdapter()

        swipeRefreshLayout.setOnRefreshListener {
            viewModel.onSwipeToRefresh()
        }

        viewModel.songs.observe(this, Observer {

            if (it.isNotEmpty()) {
                recyclerView.visibility = VISIBLE
                emptyState.visibility = GONE
            } else {
                recyclerView.visibility = GONE
                emptyState.visibility = VISIBLE
            }

            (recyclerView.adapter as ShuffleSongAdapter).update(it)
            swipeRefreshLayout.isRefreshing = false
        })

        viewModel.start()
    }
}
