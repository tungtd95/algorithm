package greedy

class MarcCakewalk {
    fun marcsCakewalk(calorie: Array<Int>): Long {
        // Write your code here
        calorie.sortDescending()
        var miles = 0L
        calorie.forEachIndexed { index, i ->
            miles += i * Math.pow(2.toDouble(), index.toDouble()).toLong()
        }
        return miles
    }
}