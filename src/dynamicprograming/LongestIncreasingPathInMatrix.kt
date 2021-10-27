package dynamicprograming

import test.print2DArray

class LongestIncreasingPathInMatrix {

    lateinit var cache: Array<Array<Int>>

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        cache = Array(matrix.size) { Array(matrix[0].size) { -1 } }

        var longestPath = 0
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                longestPath = max(longestPath, findLongestPathInSinglePos(matrix, i, j))
            }
        }
        return longestPath
    }

    private fun findLongestPathInSinglePos(matrix: Array<IntArray>, x: Int, y: Int): Int {
        if (cache[x][y] > 0) return cache[x][y]

        var maxPathInThisPos = 0

        val upX = x
        val upY = y - 1
        if (isPosValid(matrix, upX, upY) && matrix[upX][upY] > matrix[x][y]) {
            maxPathInThisPos = max(maxPathInThisPos, findLongestPathInSinglePos(matrix, upX, upY))
        }

        val downX = x
        val downY = y + 1
        if (isPosValid(matrix, downX, downY) && matrix[downX][downY] > matrix[x][y]) {
            maxPathInThisPos = max(maxPathInThisPos, findLongestPathInSinglePos(matrix, downX, downY))
        }

        val leftX = x - 1
        val leftY = y
        if (isPosValid(matrix, leftX, leftY) && matrix[leftX][leftY] > matrix[x][y]) {
            maxPathInThisPos = max(maxPathInThisPos, findLongestPathInSinglePos(matrix, leftX, leftY))
        }

        val rightX = x + 1
        val rightY = y
        if (isPosValid(matrix, rightX, rightY) && matrix[rightX][rightY] > matrix[x][y]) {
            maxPathInThisPos = max(maxPathInThisPos, findLongestPathInSinglePos(matrix, rightX, rightY))
        }

        return (maxPathInThisPos + 1).also { cache[x][y] = it }
    }

    private fun isPosValid(matrix: Array<IntArray>, x: Int, y: Int): Boolean =
        x in matrix.indices && y in matrix[0].indices

    private fun max(a: Int, b: Int) = if (a > b) a else b
}