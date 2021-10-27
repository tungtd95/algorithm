package submittion

import test.printList

class TrappingRainWaterOptimized {
    fun trap(height: IntArray): Int {
        val maxIdx = findMaxIdx(height)
        val left = arrayListOf<Int>()
        val right = arrayListOf<Int>()
        for (i in 0..maxIdx) {
            left.add(height[i])
        }
        for (i in (height.size - 1) downTo maxIdx) {
            right.add(height[i])
        }
//        printList(left)
//        printList(right)
        return trapWithMaxInEnd(left) + trapWithMaxInEnd(right)
    }

    private fun trapWithMaxInEnd(height: List<Int>): Int {
        if (height.size <= 2) return 0

        var maxHeight = height[0]
        var sum = 0
        for (i in 1 until height.size) {
            if (height[i] >= maxHeight) {
                maxHeight = height[i]
                continue
            }
            sum += maxHeight - height[i]
        }

        return sum
    }

    private fun findMaxIdx(height: IntArray): Int {
        var maxValue = height[0]
        var maxIdx = 0
        height.forEachIndexed { index, i ->
            if (i > maxValue) {
                maxValue = i
                maxIdx = index
            }
        }
        return maxIdx
    }
}