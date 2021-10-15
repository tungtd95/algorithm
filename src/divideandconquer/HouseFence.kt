package divideandconquer

class HouseFence {

    fun findMinStrokeCount(fences: List<Int>, leftIn: Int? = null, rightIn: Int? = null, heightPaintedIn: Int? = null): Int {
        val right = rightIn ?: fences.size - 1
        val left = leftIn ?: 0
        val heightPainted = heightPaintedIn ?: 0
        val minFenceInRange = findMinInRange(fences, left, right)

//        println("fences = $ >>>>> minFenceInRange = $minFenceInRange >>>>> left = $left >>>>> right = $right >>>>> heightPainted = $heightPainted ")
//        println()

        val currentCheckSize = right - left + 1
        if (left == right) {
            if (minFenceInRange == heightPaintedIn) {
                return 0
            } else {
                return 1
            }
        }

        if (minFenceInRange - heightPainted >= currentCheckSize) return currentCheckSize

        var minStrokeToPaint = minFenceInRange - heightPainted

        var startPoint = left
        var endPoint = left
        for (i in left..right) {
            if (fences[i] - heightPainted == 0) {
                // trigger calculation when meet 0
                minStrokeToPaint += findMinStrokeCount(fences, startPoint, endPoint, minFenceInRange)
                if (minStrokeToPaint >= currentCheckSize) {
                    return currentCheckSize
                }
                startPoint = i + 1
                endPoint = i + 1
            } else if (i == right) {
                // trigger calculation when meet end
                minStrokeToPaint += findMinStrokeCount(fences, startPoint, i, minFenceInRange)
            } else {
                // continuing searching for zero
                endPoint = i
            }
        }

        if (minStrokeToPaint >= currentCheckSize) {
            return currentCheckSize
        }
        return minStrokeToPaint
    }

    fun findMinInRange(fences: List<Int>, left: Int, right: Int): Int {
        return fences.subList(left, right + 1).minOrNull() ?: 0
    }
}

class HouseFenceSimple {
    fun findMinStroke(fences: List<Long>): Int {
        val minFence = findMinFence(fences)
        if (minFence >= fences.size) return fences.size

        val newFences = minusFences(fences, minFence)
        var minStroke = minFence

        val splitList = splitListByZero(newFences)
        splitList.forEach {
            minStroke += findMinStroke(it)
        }

        if (minStroke > fences.size) return fences.size
        else return minStroke.toInt()
    }

    fun findMinFence(fences: List<Long>): Long {
        if (fences.isEmpty()) return 0
        var min = fences[0]
        fences.forEach { if (it < min) min = it }
        return min
    }

    fun minusFences(fences: List<Long>, operator: Long): List<Long> {
        val result = arrayListOf<Long>()
        fences.forEach { result.add(it - operator) }
        return result
    }

    fun splitListByZero(raw: List<Long>): List<List<Long>> {
        val result = arrayListOf<List<Long>>()

        var list = arrayListOf<Long>()
        raw.forEach {
            if (it == 0L) {
                if (list.isNotEmpty()) result.add(list)
                list = arrayListOf()
            } else {
                list.add(it)
            }
        }
        if (list.isNotEmpty()) result.add(list)

        return result
    }
}