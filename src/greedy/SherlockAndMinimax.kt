package greedy

import kotlin.math.abs

class SherlockAndMinimax {
    fun sherlockAndMinimax(arr: Array<Int>, p: Int, q: Int): Int {
        arr.sort()

        var currentArrIdx = 0

        var minVal = Int.MIN_VALUE
        var minIdxP = 0

        for (i in p..q) {
            for (index in currentArrIdx until arr.size) {
                if (i <= arr[index]) {
                    val indexValueDelta = abs(arr[index] - i)
                    val previousValueDelta = abs((arr.getOrNull(index - 1) ?: Int.MAX_VALUE) - i)
                    // founded min in i
                    if (indexValueDelta < previousValueDelta) {
                        currentArrIdx = index
                        if (indexValueDelta > minVal) {
                            minVal = indexValueDelta
                            minIdxP = i
                        }
                        break
                    } else {
                        currentArrIdx = index - 1
                        if (previousValueDelta > minVal) {
                            minVal = previousValueDelta
                            minIdxP = i
                        }
                        break
                    }
                }
                else if (index == arr.size - 1) {
                    val delta = i - arr.last()
                    if (delta > minVal) {
                        minVal = delta
                        minIdxP = i
                    }
                }
            }
        }
        return minIdxP
    }
}