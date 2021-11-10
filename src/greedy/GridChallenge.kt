package greedy

class GridChallenge {
    fun gridChallenge(grid: Array<String>): String {
        // Write your code here
        val minChars = arrayListOf<Char>()
        val maxChars = arrayListOf<Char>()
        grid.forEach {
            val edge = findEdge(it)
            minChars.add(edge.first)
            maxChars.add(edge.second)
        }
        return if (isListAscending(minChars) && isListAscending(maxChars)) "YES" else "NO"
    }

    private fun isListAscending(chars: List<Char>): Boolean {
        for (idx in 1 until chars.size) {
            if (chars[idx] < chars[idx - 1]) {
                return false
            }
        }
        return true
    }

    private fun findEdge(input: String): Pair<Char, Char> {
        var max: Char = input[0]
        var min: Char = input[0]
        input.forEachIndexed { _, c ->
            max = maxOf(max, c)
            min = minOf(min, c)
        }
        return Pair(min, max)
    }
}