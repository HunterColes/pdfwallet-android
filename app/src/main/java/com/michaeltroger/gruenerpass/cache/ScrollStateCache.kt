package com.michaeltroger.gruenerpass.cache

/**
 * Where the pages of each document (by file name) are scrolled to,
 * so that the reading position survives rotating the device.
 */
object ScrollStateCache {
    val states = mutableMapOf<String, ScrollState>()
}

/** Page [position] and its [offset] from the top, measured while the screen was [screenWidth] wide. */
data class ScrollState(val position: Int, val offset: Int, val screenWidth: Int) {
    /** The same spot on a screen [width] wide: pages are fit to the width, so the offset scales with it. */
    fun offsetAt(width: Int): Int = offset * width / screenWidth
}
