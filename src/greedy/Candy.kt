package greedy

class Candy {
    fun candies(n: Int, arr: Array<Int>): Long {
        // Write your code here
        var minCandy = 0L

        val currentContinuousList = arrayListOf<Int>()
        currentContinuousList.add(arr.first())
        for (i in 1 until n) {
            print("${currentContinuousList.size} ")
            val isLastEquals = arr[i] == currentContinuousList.last()
            if (isLastEquals) {
                minCandy += calculateSum(currentContinuousList.size)
                currentContinuousList.clear()
                currentContinuousList.add(arr[i])
                continue
            }
            if (currentContinuousList.size == 1) {
                currentContinuousList.add(arr[i])
            } else {
                val isIncreasing = currentContinuousList[1] > currentContinuousList[0]
                val isLastIncreasing = arr[i] > currentContinuousList.last()
                if (isIncreasing != isLastIncreasing) {
                    minCandy += calculateSum(currentContinuousList.size)
                    currentContinuousList.clear()
                }
                currentContinuousList.add(arr[i])
            }
        }
        print("${currentContinuousList.size} ")
        minCandy += calculateSum(currentContinuousList.size)
        return minCandy
    }

    private fun calculateSum(size: Int): Long {
        return size.toLong() * (size.toLong() + 1) / 2
    }
}