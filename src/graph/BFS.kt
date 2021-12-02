package graph

class BFS {
    private lateinit var graph: Array<HashSet<Int>>
    private lateinit var travelCost: Array<Int>
    private val vertexQueue = arrayListOf<Int>()
    private var visitedVertex = hashSetOf<Int>()

    fun bfs(n: Int, m: Int, edges: Array<Array<Int>>, s: Int): Array<Int> {
        // Construct graph
        graph = Array(n + 1) { hashSetOf<Int>() }
        edges.forEach { ints ->
            graph[ints[0]].add(ints[1])
            graph[ints[1]].add(ints[0])
        }
        // init cost
        travelCost = Array(n + 1) { -1 }

        // start bfs
        vertexQueue.add(s)
        travelCost[s] = 0
        while (vertexQueue.isNotEmpty()) {
            val currentVertex: Int = vertexQueue.removeAt(0)
            graph[currentVertex].forEach {
                if (!visitedVertex.contains(it)) {
                    travelCost[it] = travelCost[currentVertex] + 6
                    visitedVertex.add(it)
                    vertexQueue.add(it)
                }
            }
        }
        val result = ArrayList(travelCost.takeLast(n))
        result.removeAt(s - 1)
        return result.toTypedArray()
    }
}
