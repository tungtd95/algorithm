package test

import greedy.GridChallenge
import greedy.MarcCakewalk
import greedy.MinimumAbsDiff
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GreedyTest {

    @Test
    fun `test minimum absolute different`() {
        assertEquals(
            1,
            MinimumAbsDiff().minimumAbsoluteDifference(arrayOf(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75))
        )
        assertEquals(
            3,
            MinimumAbsDiff().minimumAbsoluteDifference(arrayOf(1, -3, 71, 68, 17))
        )
    }

    @Test
    fun `test marc cake walk`() {
        assertEquals(79L, MarcCakewalk().marcsCakewalk(arrayOf(7, 4, 9, 6)))
    }

    @Test
    fun `test grid challenge`() {
        assertEquals("YES", GridChallenge().gridChallenge(arrayOf("ebacd", "fghij", "olmkn", "trpqs", "xywuv")))
    }
}