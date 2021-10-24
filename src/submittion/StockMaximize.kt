package submittion

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val prices = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()

        val result = StockMaximize().stockmax(prices)

        println(result)
    }
}

class StockMaximize {
    var maxProfit: Long = 0L

    fun stockmax(prices: Array<Long>): Long {
        // Write your code here
        findStockMax(prices)
        return maxProfit
    }

    private fun findStockMax(prices: Array<Long>) {
        if (prices.size <= 1) return
        val maxPos = findMaxPos(prices)
        var boughtPrice = 0L
        for (i in 0 until maxPos) {
            boughtPrice += prices[i]
        }
        maxProfit += (prices[maxPos] * maxPos - boughtPrice)
        stockmax(prices.takeLast(prices.size - maxPos - 1).toTypedArray())
    }

    private fun findMaxPos(prices: Array<Long>): Int {
        var max: Long = 0
        var maxIdx = 0
        prices.forEachIndexed { index, value ->
            if (value > max) {
                max = value
                maxIdx = index
            }
        }
        return maxIdx
    }
}