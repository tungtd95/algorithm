package greedy

import java.math.BigInteger

class ChiefHopper {
    fun chiefHopper(arr: Array<Int>): Int {
        // Write your code here
        var sum = BigInteger.ZERO
        val bigInteger2 = BigInteger.valueOf(2)
        val n = arr.size

        for (index in arr.indices) {
            val currentValue = BigInteger.valueOf(arr[index].toLong())
            sum = sum.plus(currentValue.multiply(bigInteger2.pow(n - index - 1)))
        }

        val n2 = bigInteger2.pow(n)
        val divideAndRemainder = sum.divideAndRemainder(n2)
        var result = divideAndRemainder[0].toInt()
        if (divideAndRemainder[1] != BigInteger.ZERO) {
            result++
        }
        return result
    }
}