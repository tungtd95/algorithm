package submittion

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        val maxIdx = findMaxIdxInRange(height, 1, height.size)
        return trapInRange(height, 1, maxIdx, false) +
                trapInRange(height, maxIdx, height.size, true)
    }

    private fun trapInRange(height: IntArray, start: Int, end: Int, isMaxStart: Boolean): Int {
        if (start == end || start == end - 1) return 0
        val sum: Int =
            if (isMaxStart) {
                val maxIdx = findMaxIdxInRange(height, start + 1, end)
                sumInRange(height, start, maxIdx, maxIdx) + trapInRange(height, maxIdx, end, true)
            } else {
                val maxIdx = findMaxIdxInRange(height, start, end - 1)
                sumInRange(height, maxIdx, end, maxIdx) + trapInRange(height, start, maxIdx, false)
            }

        return sum
    }

    private fun sumInRange(height: IntArray, start: Int, end: Int, low: Int): Int {
        var sum = (end - start - 1) * height[low - 1]
        for (i in start + 1 until end) {
            sum -= height[i - 1]
        }
        return sum
    }

    private fun findMaxIdxInRange(height: IntArray, start: Int, end: Int): Int {
        var max = height[start - 1]
        var maxIdx = start

        for (i in start..end) {
            if (height[i - 1] > max) {
                max = height[i - 1]
                maxIdx = i
            }
        }

        return maxIdx
    }
}