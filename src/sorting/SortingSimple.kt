package sorting

class SortingSimple {
    // insertion sort
    fun insertionSort(raw: List<Int>): List<Int> {
        val sortList = ArrayList(raw)
        val n = sortList.size
        for (i in 1 until n) {
            val currentItem = sortList[i]
            var nextPos = 0
            for (j in 0 until i) {
                if (currentItem >= sortList[j]) {
                    nextPos = j + 1
                }
            }
            sortList.removeAt(i)
            sortList.add(nextPos, currentItem)
        }
        return sortList
    }
}