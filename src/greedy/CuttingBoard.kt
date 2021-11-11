package greedy

class CuttingBoard {
    val modulo = 1000000007

    fun boardCutting(cost_y: Array<Int>, cost_x: Array<Int>): Int {
        // Write your code here
        cost_y.sortDescending()
        cost_x.sortDescending()
        val row = ArrayList(cost_y.toList())
        val column = ArrayList(cost_x.toList())
        var rowCount = 1
        var columnCount = 1

        var minCost = 0L

        while (row.isNotEmpty() || column.isNotEmpty()) {
            val firstRowCost = row.firstOrNull() ?: -1
            val firstColumnCost = column.firstOrNull() ?: -1

            if (firstRowCost >= firstColumnCost) {
                minCost += ((columnCount.toLong() * firstRowCost.toLong()) % modulo)
                rowCount++
                if (firstRowCost != -1) {
                    row.removeAt(0)
                }
            } else {
                minCost += ((rowCount.toLong() * firstColumnCost.toLong()) % modulo)
                columnCount++
                if (firstColumnCost != -1) {
                    column.removeAt(0)
                }
            }
            minCost %= modulo
        }
        return minCost.toInt()
    }
}