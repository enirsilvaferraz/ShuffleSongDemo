package com.eferraz.shufflesongs.view

import androidx.test.espresso.intent.rule.IntentsTestRule
import com.eferraz.shufflesongs.robot.ShuffleRobot
import org.junit.Rule
import org.junit.Test

class ShuffleActivityTest {

    @Rule
    @JvmField
    var intentTestRule = IntentsTestRule(ShuffleActivity::class.java, true, false)

    @Test
    fun testVerifyArtistName() {

        intentTestRule.launchActivity(null)

        ShuffleRobot().verifyArtistNameOnItemList(0, "Artist 1")
        ShuffleRobot().verifyArtistNameOnItemList(1, "Artist 3")
        ShuffleRobot().verifyArtistNameOnItemList(2, "Artist 2")
        ShuffleRobot().verifyArtistNameOnItemList(3, "Artist 3")
        ShuffleRobot().verifyArtistNameOnItemList(4, "Artist 1")
        ShuffleRobot().verifyArtistNameOnItemList(5, "Artist 2")
    }

    @Test
    fun testVerifyTracktName() {

        intentTestRule.launchActivity(null)

        ShuffleRobot().verifyTrackNameOnItemList(0, "Track 2")
        ShuffleRobot().verifyTrackNameOnItemList(1, "Track 5")
        ShuffleRobot().verifyTrackNameOnItemList(2, "Track 3")
        ShuffleRobot().verifyTrackNameOnItemList(3, "Track 6")
        ShuffleRobot().verifyTrackNameOnItemList(4, "Track 1")
        ShuffleRobot().verifyTrackNameOnItemList(5, "Track 4")
    }
}