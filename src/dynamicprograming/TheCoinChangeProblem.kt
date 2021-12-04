package dynamicprograming

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val c = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

    val ways = TheCoinChangeProblem().getWays(n, c)

    println(ways)
}

/**
 * 4
 * 2, 1, 3
 *
 */
class TheCoinChangeProblem {
    lateinit var cache: Array<Array<Array<Long>>>

    fun getWays(n: Int, c: Array<Int>): Long {
        // Write your code here
        cache = Array(c.size + 1) { Array(c.size + 1) { Array(n + 1) { -1L } } }
        return getWaysInRange(c, 1, c.size, n)
    }

    private fun getWaysInRange(arr: Array<Int>, start: Int, end: Int, n: Int): Long {
        if (n == 0) return 1L
        if (n < 0) return 0L
        val cacheValue = cache[start][end][n]
        if (cacheValue >= 0) return cacheValue
        var sum = 0L
        for (i in start..end) {
            sum += getWaysInRange(arr, i, end, n - arr[i - 1])
        }
        cache[start][end][n] = sum
        return sum
    }
}