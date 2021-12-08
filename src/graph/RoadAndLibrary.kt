package graph

import test.printList

class RoadAndLibrary {
    private lateinit var graph: ArrayList<HashSet<Int>>
    private lateinit var parent: ArrayList<Int>
    private lateinit var visitedVertex: HashSet<Int>

    fun roadsAndLibraries(n: Int, c_lib: Int, c_road: Int, cities: Array<Array<Int>>): Long {
        // construct graph
        graph = arrayListOf<HashSet<Int>>()
        parent = arrayListOf<Int>()
        for (i in 0 until n) {
            graph.add(hashSetOf<Int>())
            parent.add(i)
        }
        cities.forEach {
            graph[it[0] - 1].add(it[1] - 1)
            graph[it[1] - 1].add(it[0] - 1)
        }

        // start dfs
        visitedVertex = hashSetOf<Int>()
        for (i in 0 until n) {
            visit(i)
        }

        // compute result
        parent.sort()
        var result = 0L
        var currentValue = parent[0]
        var currentCount = 1
        for (i in 1 until parent.size) {
            if (parent[i] != currentValue) {
                result += minOf((currentCount - 1) * c_road + c_lib, currentCount * c_lib)
                currentCount = 0
                currentValue = parent[i]
            }
            currentCount++
        }
        result += minOf((currentCount - 1) * c_road + c_lib, currentCount * c_lib)
//        printList(parent)
        return result
    }

    private fun visit(vertex: Int) {
        if (visitedVertex.contains(vertex)) return
        visitedVertex.add(vertex)
        val adj = graph[vertex]
        val rootVertex = findRoot(vertex)
        adj.forEach {
            if (!visitedVertex.contains(it)) {
                parent[it] = rootVertex
                visit(it)
            }
        }
    }

    private fun findRoot(vertex: Int): Int {
        if (parent[vertex] == vertex) return vertex
        return findRoot(parent[vertex])
    }
}