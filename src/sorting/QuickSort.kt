package sorting

import kotlin.random.Random

class QuickSort {

    fun sort(input: List<Int>): List<Int> {
        if (input.isEmpty() || input.size == 1) return input
        val pivot = input.last()
        val left = arrayListOf<Int>()
        val right = arrayListOf<Int>()
        for (i in 0 until input.size - 1) {
            val currentItem = input[i]
            if (currentItem <= pivot) {
                left.add(currentItem)
            } else {
                right.add(currentItem)
            }
        }

        val sortedLeft = sort(left)
        val sortedRight = sort(right)
        val result = arrayListOf<Int>()
        result.addAll(sortedLeft)
        result.add(pivot)
        result.addAll(sortedRight)
        return result
    }

    /**
     * To prevent O(n^2), we choose pivot randomly
     *
     */
    fun sortRandomPivot(input: List<Int>): List<Int> {
        if (input.isEmpty() || input.size == 1) return input
        val randomIdx = Random.nextInt(0, input.size)
        val pivot = input[randomIdx]

        val left = arrayListOf<Int>()
        val right = arrayListOf<Int>()
        for (i in input.indices) {
            if (i == randomIdx) continue
            val currentItem = input[i]
            if (currentItem <= pivot) {
                left.add(currentItem)
            } else {
                right.add(currentItem)
            }
        }

        val sortedLeft = sortRandomPivot(left)
        val sortedRight = sortRandomPivot(right)
        val result = arrayListOf<Int>()
        result.addAll(sortedLeft)
        result.add(pivot)
        result.addAll(sortedRight)
        return result
    }
}