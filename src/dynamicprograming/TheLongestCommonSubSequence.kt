package dynamicprograming

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val b = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = TheLongestCommonSubSequence().longestCommonSubsequence(a, b)

    println(result.joinToString(" "))
}

class TheLongestCommonSubSequence {
    // longest with tracing
    lateinit var cacheTracingMax: Array<Array<Int>>
    lateinit var cacheTracingRoad: Array<Array<String>>


    fun longestCommonSubsequence(a: Array<Int>, b: Array<Int>): Array<Int> {
        // Write your code here
        cacheTracingMax = Array(a.size) { Array(b.size) { -1 } }
        cacheTracingRoad = Array(a.size) { Array(b.size) { "INI" } }

        val lcsLength = lcsInRange(a, b, a.size - 1, b.size - 1)
//        println(lcsLength)
//        print2DArray(cacheTracingRoad)
//        print2DArray(cacheTracingMax)
        return getLongestSubSequence(a, b, lcsLength).also {
//            it.forEach { print("$it ") }
        }
    }

    private fun lcsInRange(a: Array<Int>, b: Array<Int>, aPos: Int, bPos: Int): Int {
        if (aPos < 0 || bPos < 0) return 0
        if (cacheTracingMax[aPos][bPos] >= 0) return cacheTracingMax[aPos][bPos]

        if (a[aPos] == b[bPos]) return (1 + lcsInRange(a, b, aPos - 1, bPos - 1)).also {
            cacheTracingMax[aPos][bPos] = it
            cacheTracingRoad[aPos][bPos] = "PIK"
        }
        val aDownMax = lcsInRange(a, b, aPos - 1, bPos)
        val bDownMax = lcsInRange(a, b, aPos, bPos - 1)
        return if (aDownMax > bDownMax) {
            cacheTracingRoad[aPos][bPos] = "UPP"
            aDownMax
        } else {
            cacheTracingRoad[aPos][bPos] = "LEF"
            bDownMax
        }.also {
            cacheTracingMax[aPos][bPos] = it
        }
    }

    private fun getLongestSubSequence(a: Array<Int>, b: Array<Int>, lcsLength: Int): Array<Int> {
        for (i in a.indices) {
            for (j in b.indices) {
                if (cacheTracingMax[i][j] == lcsLength && cacheTracingRoad[i][j] == "PIK") {
                    val result = arrayListOf<Int>()
                    var x = i
                    var y = j
                    while (true) {
                        if (x < 0 || y < 0) break
                        when (cacheTracingRoad[x][y]) {
                            "PIK" -> {
                                result.add(a[x])
                                x--
                                y--
                            }
                            "UPP" -> {
                                x--
                            }
                            "LEF" -> {
                                y--
                            }
                        }
                    }
                    result.reverse()
                    return result.toTypedArray()
                }
            }
        }
        return arrayOf()
    }


    // longest no tracing
    lateinit var cacheNoTracing: Array<Array<Int>>

    fun longestNoTracing(text1: String, text2: String): Int {
        cacheNoTracing = Array(text1.length) { Array(text2.length) { -1 } }
        return longestNoTracingInRange(text1, text2, text1.length - 1, text2.length - 1)
    }

    private fun longestNoTracingInRange(text1: String, text2: String, text1Pos: Int, text2Pos: Int): Int {
        if (text1Pos < 0 || text2Pos < 0) return 0
        if (cacheNoTracing[text1Pos][text2Pos] >= 0) return cacheNoTracing[text1Pos][text2Pos]

        if (text1[text1Pos] == text2[text2Pos]) {
            return (longestNoTracingInRange(text1, text2, text1Pos - 1, text2Pos - 1) + 1).also {
                cacheNoTracing[text1Pos][text2Pos] = it
            }
        }
        return maxOf(
            longestNoTracingInRange(text1, text2, text1Pos - 1, text2Pos),
            longestNoTracingInRange(text1, text2, text1Pos, text2Pos - 1)
        ).also {
            cacheNoTracing[text1Pos][text2Pos] = it
        }
    }
}
