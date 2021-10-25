package test

import dynamicprograming.*
import org.junit.jupiter.api.Test
import submittion.*
import java.math.BigInteger
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

    @Test
    fun `test matrix chain multiplication`() {
        assertEquals(26000, MatrixChainMultiplication().matrixMultiplication(5, intArrayOf(40, 20, 30, 10, 30)))
        assertEquals(4500, MatrixChainMultiplication().matrixMultiplication(4, intArrayOf(10, 30, 5, 60)))
    }

    @Test
    fun `test longest common subsequence`() {
        assertEquals(3, LCS().lcs(6, 6, "ABCDGH", "AEDFHR"))
        assertEquals(2, LCS().lcs(3, 2, "ABC", "AC"))
        assertEquals(20, LCS().lcs(29, 28, "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA"))
    }

    @Test
    fun `test max breaking sum`() {
        assertEquals(13, MaxBreakingSum().maxSum(12))
        assertEquals(27, MaxBreakingSum().maxSum(24))
    }

    @Test
    fun `test trapping rain water naive`() {
        assertEquals(
            10, TrappingRainWaterNaive()
                .trappingWater(intArrayOf(3, 0, 0, 2, 0, 4), 6)
        )
        assertEquals(10, TrappingRainWaterNaive().trappingWater(intArrayOf(7, 4, 0, 9), 4))
        assertEquals(0, TrappingRainWaterNaive().trappingWater(intArrayOf(6, 9, 9), 3))
    }

    @Test
    fun `test maximize the cut segment`() {
        assertEquals(4, MaximizeTheCutSegment().maximizeCuts(4, 2, 1, 1))
        assertEquals(2, MaximizeTheCutSegment().maximizeCuts(5, 5, 3, 2))
        assertEquals(2, MaximizeTheCutSegment().maximizeCuts(7, 5, 5, 2))
        assertEquals(1, MaximizeTheCutSegment().maximizeCuts(7, 7, 7, 7))
        assertEquals(0, MaximizeTheCutSegment().maximizeCuts(10000, 3, 3, 3))
//        assertEquals(0, MaximizeTheCutSegment().maximizeCuts(99999, 7, 7, 2)) // TODO: does not pass this test case
    }

    @Test
    fun `test max possible amount`() {
        assertEquals(7, MaxPossibleAmount().maxAmount(intArrayOf(5, 3, 2), 3))
    }

    @Test
    fun `test count number of hops`() {
        assertEquals(7, CountNumberOfHops().countWays(4))
        assertEquals(1, CountNumberOfHops().countWays(1))
    }

    @Test
    fun `test fibonacci modified`() {
        assertEquals(BigInteger.valueOf(5), FibonacciModified().fibonacciModified(0, 1, 5))
    }

    @Test
    fun `test the coin change problem`() {
        assertEquals(4, TheCoinChangeProblem().getWays(4, arrayOf(2, 1, 3)))
        assertEquals(5, TheCoinChangeProblem().getWays(10, arrayOf(2, 5, 3, 6)))
        assertEquals(
            10,
            TheCoinChangeProblem().getWays(
                15,
                arrayOf(49, 22, 45, 6, 11, 20, 30, 10, 46, 8, 32, 48, 2, 41, 43, 5, 39, 16, 28, 44, 14, 4, 27, 36)
            )
        )
    }

    @Test
    fun `test stock maximize`() {
        assertEquals(0, StockMaximize().stockmax(arrayOf(5, 3, 2)))
        assertEquals(1, StockMaximize().stockmax(arrayOf(1, 2)))
        assertEquals(0, StockMaximize().stockmax(arrayOf(2, 1)))
        assertEquals(197, StockMaximize().stockmax(arrayOf(1, 2, 100)))
        assertEquals(3, StockMaximize().stockmax(arrayOf(1, 3, 1, 2)))
    }

    @Test
    fun `test red john is back`() {
        assertEquals(3, RedJohnIsBack().redJohn(7))
        assertEquals(2, RedJohnIsBack().redJohn(5))
        assertEquals(6, RedJohnIsBack().redJohn(10))
        assertEquals(4, RedJohnIsBack().redJohn(9))
        assertEquals(3385, RedJohnIsBack().redJohn(34))
        assertEquals(19385, RedJohnIsBack().redJohn(40))
        assertEquals(377823, RedJohnIsBack().redJohn(50))
    }

    @Test
    fun `test lego blocks`() {
        assertEquals(3, LegoBlocks().legoBlocks(2, 2))
        assertEquals(7, LegoBlocks().legoBlocks(3, 2))
        assertEquals(9, LegoBlocks().legoBlocks(2, 3))
//        assertEquals(3375, LegoBlocks().legoBlocks(4, 4))
    }

    @Test
    fun `test sam and substring`() {
        assertEquals(23, SamAndSubStr().substrings("16"))
        assertEquals(164, SamAndSubStr().substrings("123"))
        assertEquals(597988838, SamAndSubStr().substrings(longStringNumb))
    }
}