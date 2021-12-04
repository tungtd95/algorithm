package dynamicprograming

class CoinChange {
    lateinit var cache: Array<Int>

    fun coinChange(coins: IntArray, amount: Int): Int {
        cache = Array(amount + 1) { -2 }

        return count(coins, amount)
    }

    private fun count(coins: IntArray, amount: Int): Int {
        if (amount < 0) return -1
        if (amount == 0) return 0
        if (cache[amount] >= -1) return cache[amount]

        var min: Int = Int.MAX_VALUE
        for (i in coins.indices) {
            val count = count(coins, amount - coins[i])
            if (count >= 0) {
                min = minOf(min, count + 1)
            }
        }

        return (if (min == Int.MAX_VALUE) -1 else min).also { cache[amount] = it }
    }
}