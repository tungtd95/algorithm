class MaxSubArray {

    // find max sum of sub-array in a list of int
    fun findMaxSum(inputArray: List<Int>): MaxSumData {
        return findMaxSumData(inputArray, 0, inputArray.size - 1)
    }

    private fun findMaxSumData(inputArray: List<Int>, low: Int, high: Int): MaxSumData {
        if (low == high) {
            return MaxSumData(low, high, inputArray[low])
        }
        val mid = (low + high) / 2
        val maxLeft = findMaxSumData(inputArray, low, mid)
        val maxRight = findMaxSumData(inputArray, mid + 1, high)
        val maxMiddle = findMaxSumDataMiddle(inputArray, low, high)
        return findMaxInMaxSumList(listOf(maxLeft, maxRight, maxMiddle))
    }

    private fun findMaxSumDataMiddle(inputArray: List<Int>, low: Int, high: Int): MaxSumData {
        val mid: Int = (low + high) / 2

        // find max left sum and lowToFind
        var leftSum = inputArray[mid]
        var lowToFind = mid
        var progressLeftSum = 0
        for (i in mid downTo low) {
            progressLeftSum += inputArray[i]
            if (progressLeftSum > leftSum) {
                leftSum = progressLeftSum
                lowToFind = i
            }
        }

        // find max right sum and highToFind
        var rightSum = inputArray[mid + 1]
        var highToFind = mid
        var progressRightSum = 0
        for (i in mid + 1..high) {
            progressRightSum += inputArray[i]
            if (progressRightSum > rightSum) {
                rightSum = progressRightSum
                highToFind = i
            }
        }
        return MaxSumData(lowToFind, highToFind, rightSum + leftSum)
    }

    private fun findMaxInMaxSumList(maxSumDataList: List<MaxSumData>): MaxSumData {
        if (maxSumDataList.isEmpty()) return MaxSumData(0, 0, 0)
        var max = maxSumDataList.first()
        maxSumDataList.forEach { if (it.sum > max.sum) max = it }
        return max
    }
}


class MaxSubArray2 {
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
        for (i in middleIdx + 1..high) {
            progressRightSum += arr[i]
            if (progressRightSum > maxRight) {
                maxRight = progressRightSum
            }
        }

        return maxLeft + maxRight
    }
}

data class MaxSumData(val low: Int, val high: Int, val sum: Int)
