package submittion

import java.math.BigInteger

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val t1 = first_multiple_input[0].toInt()

    val t2 = first_multiple_input[1].toInt()

    val n = first_multiple_input[2].toInt()

    val result = FibonacciModified().fibonacciModified(t1, t2, n)

    println(result)
}

class FibonacciModified {

    var firstNum: BigInteger = BigInteger.ZERO
    var secondNum: BigInteger = BigInteger.ZERO
    fun fibonacciModified(t1: Int, t2: Int, n: Int): BigInteger {
        // Write your code here
        firstNum = BigInteger.valueOf(t1.toLong())
        secondNum = BigInteger.valueOf(t2.toLong())
        for (i in 2 until n) {
            val nextNum = firstNum + secondNum.pow(2)
            firstNum = secondNum
            secondNum = nextNum
        }
        return secondNum.also { println(it) }
    }

}