/**
 * Find max sub-array problem https://www.hackerrank.com/challenges/maxsubarray/problem
 *
 */

fun maxSubarray(arr: Array<Int>): Array<Int> {
    // Write your code here
    val maxSubArr = findMaxSubArray(arr, 0, arr.size - 1)

    return arrayOf(maxSubArr, findMaxSubSeq(arr))
}

fun findMaxSubSeq(arr: Array<Int>): Int {
    var maxNegative = Int.MIN_VALUE
    var maxPositiveSum = 0
    var onlyNegative = true
    arr.forEach {
        if (it >= 0) {
            maxPositiveSum += it
            onlyNegative = false
        }
        if (maxNegative < it) {
            maxNegative = it
        }
    }
    return if (onlyNegative) maxNegative
    else maxPositiveSum
}

fun findMaxSubArray(arr: Array<Int>, low: Int, high: Int): Int {
    if (low == high) return arr[low]
    val midIdx = (low + high) / 2
    val leftMax = findMaxSubArray(arr, low, midIdx)
    val rightMax = findMaxSubArray(arr, midIdx + 1, high)
    val middleMax = findMaxSubMiddleArray(arr, low, high)

    var max = leftMax
    if (rightMax > max) max = rightMax
    if (middleMax > max) max = middleMax
    return max
}

fun findMaxSubMiddleArray(arr: Array<Int>, low: Int, high: Int): Int {
    val middleIdx = (low + high) / 2

    var maxLeft = arr[middleIdx]
    var progressLeftSum = 0
    for (i in middleIdx downTo low) {
        progressLeftSum += arr[i]
        if (progressLeftSum > maxLeft) {
            maxLeft = progressLeftSum
        }
    }

    var maxRight = 0
    var progressRightSum = 0
    for (i in middleIdx+1..high) {
        progressRightSum += arr[i]
        if (progressRightSum > maxRight) {
            maxRight = progressRightSum
        }
    }

    return maxLeft + maxRight
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val result = maxSubarray(arr)

        println(result.joinToString(" "))
    }
}
