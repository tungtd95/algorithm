package dynamicprograming

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {

        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val k = first_multiple_input[1].toInt()

        val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        val result = Knapsack().unboundedKnapsack(k, arr)

        println(result)
    }
}

class Knapsack {
    lateinit var cache: HashMap<Int, Int>

    fun unboundedKnapsack(k: Int, arr: Array<Int>): Int {
        // Write your code here
        cache = HashMap()
        val filterInput = arr.toSet().toTypedArray()
        val minInput = min(filterInput)
        val minOutput = unboundedKnapsackFilter(k, arr.toSet().toTypedArray(), minInput)
        return k - minOutput
    }

    private fun unboundedKnapsackFilter(k: Int, arr: Array<Int>, minInput: Int): Int {
        if (k < minInput) return k
        if (cache[k] != null) return cache[k]!!

        var min = Int.MAX_VALUE
        arr.forEach {
            val minProgress = unboundedKnapsackFilter(k - it, arr, minInput)
            if (minProgress < min && minProgress >= 0) {
                min = minProgress
            }
        }
        cache[k] = min
        return min
    }

    private fun min(arr: Array<Int>): Int {
        var min = Int.MAX_VALUE
        arr.forEach {
            if (it < min) {
                min = it
            }
        }
        return min
    }
}