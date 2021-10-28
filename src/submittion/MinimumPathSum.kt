package submittion

import test.print2DArray

class MinimumPathSum {
    lateinit var cache: Array<Array<Int>>

    fun minPathSum(grid: Array<IntArray>): Int {
        cache = Array(grid.size) { Array(grid[0].size) { -1 } }
//        print2DArray(grid)
//        println()
        return findMinPathInPos(grid, 0, 0).also {
//            print2DArray(cache)
        }
    }

    private fun findMinPathInPos(grid: Array<IntArray>, x: Int, y: Int): Int {
        if (cache[x][y] > 0) return cache[x][y]

        var minPath = 0

        val downX = x + 1
        val downY = y
        var pathDown = -1
        if (isPosValid(grid, downX, downY)) {
            pathDown = findMinPathInPos(grid, downX, downY)
        }

        val rightX = x
        val rightY = y + 1
        var pathRight = -1
        if (isPosValid(grid, rightX, rightY)) {
            pathRight = findMinPathInPos(grid, rightX, rightY)
        }

        if (pathDown >= 0 && pathRight >= 0) {
            minPath = minOf(pathDown, pathRight)
        } else if (pathDown >= 0 && pathRight < 0) {
            minPath = pathDown
        } else if (pathDown < 0 && pathRight >= 0) {
            minPath = pathRight
        }

        return (grid[x][y] + minPath).also {
            cache[x][y] = it
        }
    }

    private fun isPosValid(grid: Array<IntArray>, x: Int, y: Int) = x in grid.indices && y in grid[0].indices
}