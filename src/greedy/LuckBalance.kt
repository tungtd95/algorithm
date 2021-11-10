package greedy

class LuckBalance {
    fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
        // Write your code here
        val importances = arrayListOf<Int>()
        val unImportances = arrayListOf<Int>()
        contests.forEach {
            if (it[1] == 0) {
                unImportances.add(it[0])
            } else {
                importances.add(it[0])
            }
        }
        importances.sortDescending()
        var lastCount = importances.size - k
        if (lastCount < 0) lastCount = 0
        return unImportances.sum() + importances.take(k).sum() - importances.takeLast(lastCount).sum()
    }
}