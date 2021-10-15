package sorting

class MergeSort {
    // merge sort
    fun mergeSort(raw: List<Int>): List<Int> {
        val toSortList = ArrayList<Int>(raw)
        val listSize = toSortList.size
        if (listSize == 1) return toSortList

        val firstList = mergeSort(toSortList.subList(0, listSize / 2))
        val secondList = mergeSort(toSortList.subList(listSize / 2, listSize))

        return merge(firstList, secondList)
    }

    // first list and second list suppose to be sorted
    // the function return a sorted list after merge 2 list
    private fun merge(firstList: List<Int>, secondList: List<Int>): List<Int> {
        val result = arrayListOf<Int>()
        val firstListMarked = ArrayList(firstList)
        val secondListMarked = ArrayList(secondList)

        while (firstListMarked.isNotEmpty() && secondListMarked.isNotEmpty()) {
            val topFirst = firstListMarked.first()
            val topSecond = secondListMarked.first()
            if (topFirst <= topSecond) {
                result.add(topFirst)
                firstListMarked.removeAt(0)
            } else {
                result.add(topSecond)
                secondListMarked.removeAt(0)
            }
        }
        if (firstListMarked.isNotEmpty()) result.addAll(firstListMarked)
        if (secondListMarked.isNotEmpty()) result.addAll(secondListMarked)

        return result
    }
}