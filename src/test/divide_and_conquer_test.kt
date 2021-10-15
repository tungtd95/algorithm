package test

import MaxSubArray
import MaxSubArray2
import divideandconquer.HouseFence
import divideandconquer.HouseFenceSimple
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DivideAndConquerTest {

    @Test
    fun findMaxSum() {
        val result1 = MaxSubArray().findMaxSum(listOf(1, 2, -1, -1, 3, 4))
        assertEquals(8, result1.sum)

        val result2 = MaxSubArray().findMaxSum(listOf(2, -1, 2, 3, 4, -5))
        assertEquals(10, result2.sum)
    }

    @Test
    fun maxSubarray() {
        val result1 = MaxSubArray2().maxSubarray(arrayOf(1, 2, 3, 4))
        assertEquals(10, result1.first())
        assertEquals(10, result1.last())

        val result2 = MaxSubArray2().maxSubarray(arrayOf(2, -1, 2, 3, 4, -5))
        assertEquals(10, result2.first())
        assertEquals(11, result2.last())

        val result3 = MaxSubArray2().maxSubarray(arrayOf(-2, -3, -1, -4, -6))
        assertEquals(-1, result3.first())
        assertEquals(-1, result3.last())

        val result4 = MaxSubArray2().maxSubarray(arrayOf(1, 2, -1, -1, 3, 4))
        assertEquals(8, result4.first())
    }

    @Test
    fun testHouseFence() {
        assertEquals(3, HouseFence().findMinStrokeCount(listOf(2, 2, 6, 2)))
        assertEquals(3, HouseFence().findMinStrokeCount(listOf(2, 2, 1, 2, 1)))
        assertEquals(2, HouseFence().findMinStrokeCount(listOf(2, 2)))
        assertEquals(1, HouseFence().findMinStrokeCount(listOf(5)))

        assertEquals(6, HouseFence().findMinStrokeCount(listOf(3, 5, 4, 1, 4, 5)))
        assertEquals(6, HouseFence().findMinStrokeCount(listOf(5, 5, 1, 5, 5, 4, 1)))
        assertEquals(4, HouseFence().findMinStrokeCount(listOf(3, 4, 5, 6)))
        assertEquals(4, HouseFence().findMinStrokeCount(listOf(2, 3, 4, 5)))
        assertEquals(8, HouseFence().findMinStrokeCount(listOf(5000, 5000, 5, 5000, 5000, 5000, 5000, 5000)))
        assertEquals(6, HouseFence().findMinStrokeCount(listOf(4, 4, 4, 3, 4, 4, 3, 4, 4, 4)))
        assertEquals(5, HouseFence().findMinStrokeCount(listOf(4, 4, 4, 4, 20, 4, 4, 4, 4)))
        assertEquals(26, HouseFence().findMinStrokeCount(listOf(1, 4, 5, 3, 9, 7, 8, 4, 5, 9, 2, 3, 4, 2, 3, 4, 5, 5, 6, 8, 1, 2, 9, 4, 3, 7, 2, 6, 5, 4)))
    }

    @Test
    fun testHouseFenceSimple() {
        assertEquals(3, HouseFenceSimple().findMinStroke(listOf(2, 2, 6, 2)))
        assertEquals(3, HouseFenceSimple().findMinStroke(listOf(2, 2, 1, 2, 1)))
        assertEquals(2, HouseFenceSimple().findMinStroke(listOf(2, 2)))
        assertEquals(1, HouseFenceSimple().findMinStroke(listOf(5)))

        assertEquals(6, HouseFenceSimple().findMinStroke(listOf(3, 5, 4, 1, 4, 5)))
        assertEquals(6, HouseFenceSimple().findMinStroke(listOf(5, 5, 1, 5, 5, 4, 1)))
        assertEquals(4, HouseFenceSimple().findMinStroke(listOf(3, 4, 5, 6)))
        assertEquals(4, HouseFenceSimple().findMinStroke(listOf(2, 3, 4, 5)))
        assertEquals(8, HouseFenceSimple().findMinStroke(listOf(5000, 5000, 5, 5000, 5000, 5000, 5000, 5000)))
        assertEquals(6, HouseFenceSimple().findMinStroke(listOf(4, 4, 4, 3, 4, 4, 3, 4, 4, 4)))
        assertEquals(5, HouseFenceSimple().findMinStroke(listOf(4, 4, 4, 4, 20, 4, 4, 4, 4)))
        assertEquals(26, HouseFenceSimple().findMinStroke(listOf(1, 4, 5, 3, 9, 7, 8, 4, 5, 9, 2, 3, 4, 2, 3, 4, 5, 5, 6, 8, 1, 2, 9, 4, 3, 7, 2, 6, 5, 4)))
    }
}