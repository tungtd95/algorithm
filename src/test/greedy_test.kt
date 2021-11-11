package test

import greedy.*
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Paths
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

    @Test
    fun `test luck balance`() {
        assertEquals(
            29,
            LuckBalance().luckBalance(
                3,
                arrayOf(arrayOf(5, 1), arrayOf(2, 1), arrayOf(1, 1), arrayOf(8, 1), arrayOf(10, 0), arrayOf(5, 0))
            )
        )
        assertEquals(
            10,
            LuckBalance().luckBalance(
                2,
                arrayOf(arrayOf(5, 0), arrayOf(1, 1), arrayOf(4, 0))
            )
        )
    }

    @Test
    fun `test candy`() {
        assertEquals(10, Candy().candies(6, arrayOf(4, 6, 4, 5, 6, 2)))
//        assertEquals(5, Candy().candies(4, arrayOf(1, 2, 2, 2)))
//        assertEquals(4, Candy().candies(3, arrayOf(1, 2, 2)))
//
//        val inputStream = File("${Paths.get("").toAbsolutePath()}/src/test/test_candy.dat").inputStream()
//        val longArr = arrayListOf<Int>()
//        inputStream.bufferedReader().useLines {
//            it.forEach {
//                longArr.add(it.toInt())
//            }
//        }
//        assertEquals(33556, Candy().candies(16387, longArr.toTypedArray()))

//        val inputStream2 = File("${Paths.get("").toAbsolutePath()}/src/test/test_candy_2.dat").inputStream()
//        val longArr2 = arrayListOf<Int>()
//        inputStream2.bufferedReader().useLines {
//            it.forEach {
//                longArr2.add(it.toInt())
//            }
//        }
//        assertEquals(5000050000, Candy().candies(100000, longArr2.toTypedArray()))
    }

    @Test
    fun `test greedy florist`() {
        assertEquals(15, GreedyFlorist().getMinimumCost(2, arrayOf(2, 5, 6)))
        assertEquals(13, GreedyFlorist().getMinimumCost(3, arrayOf(2, 5, 6)))
        assertEquals(29, GreedyFlorist().getMinimumCost(3, arrayOf(1, 3, 5, 7, 9)))
    }

    @Test
    fun `test max min`() {
        assertEquals(20, MaxMin().maxMin(3, arrayOf(10, 100, 300, 200, 1000, 20, 30)))
    }
}