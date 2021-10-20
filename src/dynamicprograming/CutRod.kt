package dynamicprograming

class CutRod {

    fun cut(prices: List<Int>, length: Int): Int {
        val maxRevenueCache = arrayListOf<Int>()
        for (i in 0..length) maxRevenueCache.add(Int.MIN_VALUE)
        return cutMemorized(prices, length, maxRevenueCache)
    }

    private fun cutMemorized(prices: List<Int>, length: Int, maxRevenueCache: ArrayList<Int>): Int {
        if (length == 0) return 0
        if (maxRevenueCache[length] > 0) return maxRevenueCache[length]
        var maxRevenue = Int.MIN_VALUE
        for (i in 1..length) {
            maxRevenue = maxOf(maxRevenue, prices[i - 1] + cutMemorized(prices, length - i, maxRevenueCache))
        }
        maxRevenueCache[length] = maxRevenue
        return maxRevenue
    }
}