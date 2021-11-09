package greedy

import kotlin.random.Random

class MinimumAbsDiff {
    fun minimumAbsoluteDifference(arr: Array<Int>): Int {
        // Write your code here
        val sortedInput = quickSortList(arr.toList())
        var min = Int.MAX_VALUE
        for (i in 1 until sortedInput.size) {
            min = minOf(min, Math.abs(sortedInput[i] - sortedInput[i - 1]))
        }
        return min
    }

    private fun quickSortList(input: List<Int>): List<Int> {
        if (input.size <= 1) return input

        val randomPivotIdx = Random.nextInt(input.size)
        val left = arrayListOf<Int>()
        val right = arrayListOf<Int>()

        input.forEachIndexed { index, i ->
            if (index != randomPivotIdx) {
                if (i > input[randomPivotIdx]) {
                    right.add(i)
                } else {
                    left.add(i)
                }
            }
        }

        val result = arrayListOf<Int>()
        result.addAll(quickSortList(left))
        result.add(input[randomPivotIdx])
        result.addAll(quickSortList(right))
        return result
    }
}