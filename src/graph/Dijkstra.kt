package graph

class Dijkstra {
    fun shortestReach(n: Int, edgesRaw: Array<Array<Int>>, s: Int): Array<Int> {
        // construct graph
        val graph = arrayListOf<HashSet<Int>>()
        val weights = Array(n + 1) { Array(n + 1) { Int.MAX_VALUE } }
        for (i in 0..n) {
            graph.add(hashSetOf<Int>())
        }
        edgesRaw.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
            weights[it[0]][it[1]] = minOf(weights[it[0]][it[1]], it[2])
            weights[it[1]][it[0]] = minOf(weights[it[1]][it[0]], it[2])
        }

        // init values
        val distances = arrayListOf<Int>()
        val originalVertex = arrayListOf<Int>()
        for (i in 0 until n) {
            distances.add(Int.MAX_VALUE)
            originalVertex.add(i + 1)
        }

        // start dijkstra
        distances[s - 1] = 0
        while (originalVertex.isNotEmpty()) {
            val minVertex = findMinDistanceVertex(distances, originalVertex).also { originalVertex.remove(it) }
            val minVertexDistance = distances[minVertex - 1]
            val adj = graph[minVertex]
            adj.forEach { v ->
                val weightSum = if (minVertexDistance == Int.MAX_VALUE) {
                    Int.MAX_VALUE
                } else {
                    weights[minVertex][v] + minVertexDistance
                }
                distances[v - 1] = minOf(distances[v - 1], weightSum)
            }
        }

        distances.removeAt(s - 1)
        distances.forEachIndexed { index, value ->
            if (value == Int.MAX_VALUE) distances[index] = -1
        }
        return distances.toTypedArray()
    }

    private fun findMinDistanceVertex(distances: ArrayList<Int>, vertexes: ArrayList<Int>): Int {
        var vertex = vertexes[0]
        var distance = distances[vertex - 1]
        vertexes.forEach { v ->
            if (distances[v - 1] < distance) {
                distance = distances[v - 1]
                vertex = v
            }
        }
        return vertex
    }
}