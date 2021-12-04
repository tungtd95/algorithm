package dynamicprograming

/**
 * submission for House Fence https://codeforces.com/contest/448/problem/C
 *
 */

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toList()

    print(findMinStrokeCount(arr))
}

fun findMinStrokeCount(fences: List<Int>, leftIn: Int? = null, rightIn: Int? = null, heightPaintedIn: Int? = null): Int {
    val right = rightIn ?: fences.size - 1
    val left = leftIn ?: 0
    val heightPainted = heightPaintedIn ?: 0
    val minFenceInRange = findMinInRange(fences, left, right)

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
