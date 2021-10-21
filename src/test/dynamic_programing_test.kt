package test

import dynamicprograming.CutRod
import dynamicprograming.Fibonacci
import dynamicprograming.MaxPathMatrix
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DynamicProgramingTest {

    @Test
    fun `test cut rod`() {
        assertEquals(30, CutRod().cut(listOf(1, 5, 8, 9, 10, 17, 17, 20, 24, 30), 10))
        assertEquals(10, CutRod().cut(listOf(1, 5, 8, 9, 10, 17, 17, 20, 24, 30), 4))
    }

    @Test
    fun `test fibonacci`() {
        assertEquals(55, Fibonacci().nthFibonacci(10))
        assertEquals(517691607, Fibonacci().nthFibonacci(1000))
    }

    @Test
    fun `test max path matrix`() {
        assertEquals(1009, MaxPathMatrix().maximumPath(2, arrayOf(intArrayOf(348, 391), intArrayOf(618, 193))))
        assertEquals(4, MaxPathMatrix().maximumPath(2, arrayOf(intArrayOf(2, 2), intArrayOf(2, 2))))
        assertEquals(
            20,
            MaxPathMatrix().maximumPath(3, arrayOf(intArrayOf(6, 7, 4), intArrayOf(7, 6, 1), intArrayOf(3, 5, 7)))
        )
    }
}