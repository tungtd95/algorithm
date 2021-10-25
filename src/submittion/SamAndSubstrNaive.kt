package submittion

import kotlin.math.pow

fun main(args: Array<String>) {
    val n = readLine()!!

    val result = SamAndSubstrNaive().substrings(n)

    println(result)
}

class SamAndSubstrNaive {
    val modulo = 1000000007
    lateinit var cache: Array<Array<Long>>

    fun substrings(n: String): Long {
        // Write your code here
        var sum = 0L
        val sizeN = n.length

        cache = Array(sizeN + 1) { Array(sizeN + 1) { -1L } }

        for (subLength in 1..sizeN) {
            for (i in 0 until sizeN) {
                if (i + subLength <= sizeN) {
                    val start = i
                    val end = i + subLength

                    val value: Long =
                        if (cache[start + 1][end] >= 0) {
                            cache[start + 1][end] + n.substring(start, start + 1).toInt() * 10.toDouble()
                                .pow((end - start - 1))
                                .toLong()
                        } else {
                            try {
                                n.substring(start, end).toLong()
                            } catch (e: Exception) {
                                e.stackTrace
                                0
                            }
                        }
                    sum += (value % modulo)
                    sum %= modulo
                    cache[start][end] = value
                } else {
                    break
                }
            }
        }
        return sum
    }
}

class SamAndSubStr {
    val modulo = 1000000007

    fun substrings(n: String): Long {
        // Write your code here
        var sum = 0L
        var lastSumProgress = 0L

        for (i in 1..n.length) {
            lastSumProgress = n[i - 1].toString().toInt() * i + lastSumProgress * 10
            lastSumProgress %= modulo
            sum += lastSumProgress
            sum %= modulo
        }

        return sum
    }
}