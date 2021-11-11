package greedy

import test.printList

class MaxMin {
    fun maxMin(k: Int, arr: Array<Int>): Int {
        // Write your code here
        arr.sort()
        var min = Int.MAX_VALUE
        for (i in 0..arr.size - k) {
            min = minOf(min, arr[i + k - 1] - arr[i])
            if (min == 0) break
        }
        return min
    }
}