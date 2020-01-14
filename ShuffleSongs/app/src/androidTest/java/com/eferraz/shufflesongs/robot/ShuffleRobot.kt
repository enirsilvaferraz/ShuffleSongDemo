package com.eferraz.shufflesongs.robot

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.eferraz.shufflesongs.R
import com.eferraz.shufflesongs.infra.CustomViewMatchers.atPosition
import org.hamcrest.core.AllOf.allOf


class ShuffleRobot {

    fun verifyArtistNameOnItemList(position: Int, artist: String) = apply {
        verifyItemView(position, R.id.artistName, artist)
    }

    fun verifyTrackNameOnItemList(position: Int, song: String) = apply {
        verifyItemView(position, R.id.songName, song)
    }

    private fun verifyItemView(position: Int, id: Int, text: String) {
        onView(
            withId(R.id.recyclerView)
        ).check(
            matches(
                atPosition(
                    position,
                    hasDescendant(
                        allOf(
                            withId(id),
                            withText(text)
                        )
                    )
                )
            )
        )
    }
}
