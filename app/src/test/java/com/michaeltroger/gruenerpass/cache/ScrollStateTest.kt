package com.michaeltroger.gruenerpass.cache

import org.junit.Assert.assertEquals
import org.junit.Test

class ScrollStateTest {

    @Test
    fun offsetStaysTheSameOnTheSameScreenWidth() {
        val state = ScrollState(position = 7, offset = -800, screenWidth = 1080)

        assertEquals(-800, state.offsetAt(1080))
    }

    @Test
    fun offsetGrowsWithTheScreenWidthWhenRotatingToLandscape() {
        val state = ScrollState(position = 7, offset = -900, screenWidth = 1080)

        assertEquals(-2000, state.offsetAt(2400))
    }

    @Test
    fun offsetShrinksWithTheScreenWidthWhenRotatingToPortrait() {
        val state = ScrollState(position = 7, offset = -2000, screenWidth = 2400)

        assertEquals(-900, state.offsetAt(1080))
    }
}
