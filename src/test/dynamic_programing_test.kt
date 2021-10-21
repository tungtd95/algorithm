package test

import dynamicprograming.CutRod
import dynamicprograming.Fibonacci
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
}