package io.github.rocxteady.sheets.test

import androidx.compose.ui.test.MainTestClock

fun MainTestClock.advanceTimeUntilSheetAnimationEnd() {
    advanceTimeByFrame()
    advanceTimeBy(500)
    advanceTimeByFrames(5)
}

fun MainTestClock.advanceTimeByFrames(frameCount: Int) {
    repeat(frameCount) {
        advanceTimeByFrame()
    }
}