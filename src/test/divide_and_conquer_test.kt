package test

import DaCHouseFence
import DaCHouseFenceSimple
import DaCMaxSum1
import DaCMaxSum2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class divide_and_conquer_test {

    @Test
    fun findMaxSum() {
        val result1 = DaCMaxSum1().findMaxSum(listOf(1, 2, -1, -1, 3, 4))
        assertEquals(8, result1.sum)

        val result2 = DaCMaxSum1().findMaxSum(listOf(2, -1, 2, 3, 4, -5))
        assertEquals(10, result2.sum)
    }

    @Test
    fun maxSubarray() {
        val result1 = DaCMaxSum2().maxSubarray(arrayOf(1, 2, 3, 4))
        assertEquals(10, result1.first())
        assertEquals(10, result1.last())

        val result2 = DaCMaxSum2().maxSubarray(arrayOf(2, -1, 2, 3, 4, -5))
        assertEquals(10, result2.first())
        assertEquals(11, result2.last())

        val result3 = DaCMaxSum2().maxSubarray(arrayOf(-2, -3, -1, -4, -6))
        assertEquals(-1, result3.first())
        assertEquals(-1, result3.last())

        val result4 = DaCMaxSum2().maxSubarray(arrayOf(1, 2, -1, -1, 3, 4))
        assertEquals(8, result4.first())
    }

    @Test
    fun testHouseFence() {
        assertEquals(3, DaCHouseFence().findMinStrokeCount(listOf(2, 2, 6, 2)))
        assertEquals(3, DaCHouseFence().findMinStrokeCount(listOf(2, 2, 1, 2, 1)))
        assertEquals(2, DaCHouseFence().findMinStrokeCount(listOf(2, 2)))
        assertEquals(1, DaCHouseFence().findMinStrokeCount(listOf(5)))

        assertEquals(6, DaCHouseFence().findMinStrokeCount(listOf(3, 5, 4, 1, 4, 5)))
        assertEquals(6, DaCHouseFence().findMinStrokeCount(listOf(5, 5, 1, 5, 5, 4, 1)))
        assertEquals(4, DaCHouseFence().findMinStrokeCount(listOf(3, 4, 5, 6)))
        assertEquals(4, DaCHouseFence().findMinStrokeCount(listOf(2, 3, 4, 5)))
        assertEquals(8, DaCHouseFence().findMinStrokeCount(listOf(5000, 5000, 5, 5000, 5000, 5000, 5000, 5000)))
        assertEquals(6, DaCHouseFence().findMinStrokeCount(listOf(4, 4, 4, 3, 4, 4, 3, 4, 4, 4)))
        assertEquals(5, DaCHouseFence().findMinStrokeCount(listOf(4, 4, 4, 4, 20, 4, 4, 4, 4)))
        assertEquals(26, DaCHouseFence().findMinStrokeCount(listOf(1, 4, 5, 3, 9, 7, 8, 4, 5, 9, 2, 3, 4, 2, 3, 4, 5, 5, 6, 8, 1, 2, 9, 4, 3, 7, 2, 6, 5, 4)))
    }

    @Test
    fun testHouseFenceSimple() {
        assertEquals(3, DaCHouseFenceSimple().findMinStroke(listOf(2, 2, 6, 2)))
        assertEquals(3, DaCHouseFenceSimple().findMinStroke(listOf(2, 2, 1, 2, 1)))
        assertEquals(2, DaCHouseFenceSimple().findMinStroke(listOf(2, 2)))
        assertEquals(1, DaCHouseFenceSimple().findMinStroke(listOf(5)))

        assertEquals(6, DaCHouseFenceSimple().findMinStroke(listOf(3, 5, 4, 1, 4, 5)))
        assertEquals(6, DaCHouseFenceSimple().findMinStroke(listOf(5, 5, 1, 5, 5, 4, 1)))
        assertEquals(4, DaCHouseFenceSimple().findMinStroke(listOf(3, 4, 5, 6)))
        assertEquals(4, DaCHouseFenceSimple().findMinStroke(listOf(2, 3, 4, 5)))
        assertEquals(8, DaCHouseFenceSimple().findMinStroke(listOf(5000, 5000, 5, 5000, 5000, 5000, 5000, 5000)))
        assertEquals(6, DaCHouseFenceSimple().findMinStroke(listOf(4, 4, 4, 3, 4, 4, 3, 4, 4, 4)))
        assertEquals(5, DaCHouseFenceSimple().findMinStroke(listOf(4, 4, 4, 4, 20, 4, 4, 4, 4)))
        assertEquals(26, DaCHouseFenceSimple().findMinStroke(listOf(1, 4, 5, 3, 9, 7, 8, 4, 5, 9, 2, 3, 4, 2, 3, 4, 5, 5, 6, 8, 1, 2, 9, 4, 3, 7, 2, 6, 5, 4)))
    }
}