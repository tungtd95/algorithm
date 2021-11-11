package greedy

class GreedyFlorist {
    fun getMinimumCost(k: Int, c: Array<Int>): Int {
        c.sortDescending()
        var minimumCost = 0
        c.forEachIndexed { index, value ->
            minimumCost += value * (1 + (index / k))
        }
        return minimumCost
    }
}