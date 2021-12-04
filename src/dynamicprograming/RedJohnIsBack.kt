package dynamicprograming

import kotlin.math.sqrt

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val result = RedJohnIsBack().redJohn(n)

        println(result)
    }
}

class RedJohnIsBack {
    lateinit var cache: Array<Array<Int>>

    fun redJohn(n: Int): Int {
        cache = Array(n + 1) { Array(n + 1) { -1 } }
        // Write your code here
        var wayOfArrangement = 0
        val max4Possible: Int = n / 4
        for (i in 0..max4Possible) {
            val numb1Remain = n - i * 4
            wayOfArrangement += combi(numb1Remain, i)
        }
        return primeCount(wayOfArrangement)
    }

    private fun combi(firstNumCount: Int, secondNumCount: Int): Int {
        if (firstNumCount == 0 || secondNumCount == 0) return 1
        if (firstNumCount == 1 || secondNumCount == 1) return firstNumCount * secondNumCount + 1
        if (cache[firstNumCount][secondNumCount] > 0) return cache[firstNumCount][secondNumCount]

        var sum = 0
        for (i in 0..secondNumCount) {
            sum += combi(firstNumCount - 1, i)
        }

        cache[firstNumCount][secondNumCount] = sum
        cache[secondNumCount][firstNumCount] = sum
        return sum
    }

    private fun primeCount(n: Int): Int {
        if (n < 2) return 0
        if (n == 2) return 1
        if (n == 3) return 2
        var primeCount = 2
        for (i in 4..n) {
            var isPrime = true
            val dividerLimit: Int = sqrt(i.toDouble()).toInt()
            for (j in 2..dividerLimit) {
                if (i % j == 0) {
                    isPrime = false
                    break
                }
            }
            if (isPrime) primeCount++
        }
        return primeCount
    }
}