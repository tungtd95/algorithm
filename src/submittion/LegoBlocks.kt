package submittion

import kotlin.math.pow

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val result = LegoBlocks().legoBlocks(n, m)

        println(result)
    }
}

class LegoBlocks {

    /**
     * combination of 4 3 2 that make n
     */

    fun legoBlocks(n: Int, m: Int): Int {
        // Write your code here
        return combi(n, m)
    }

    private fun combi(n: Int, m: Int): Int {
        if (m == 0) return 1
        if (m < 0) return 0
        val wayOf4Combination = (8.toDouble().pow(n.toDouble()) - 7.toDouble().pow(n.toDouble())).toInt()
        val wayOf3Combination = (4.toDouble().pow(n.toDouble()) - 3.toDouble().pow(n.toDouble())).toInt()
        val wayOf2Combination = (2.toDouble().pow(n.toDouble()) - 1).toInt()
//        if (m == 6) {
//            return (wayOf3Combination.toDouble().pow(2) +
//                    wayOf4Combination * wayOf2Combination +
//                    wayOf2Combination.toDouble().pow(3)).toInt()
//        }

        val combi4 = combi(n, m - 4) * wayOf4Combination
        val combi3 = combi(n, m - 3) * wayOf3Combination
        val combi2 = combi(n, m - 2) * wayOf2Combination

        println("combi4 = $combi4 >> combi3 = $combi3 >> combi2 = $combi2")

        return combi2 + combi3 + combi4
    }
}
