package graph

import java.util.*

class Prim {
    fun prims(n: Int, edgesRaw: Array<Array<Int>>, start: Int): Int {
        val graph = Array(n + 1) { hashSetOf<Edge>() }
        edgesRaw.forEach {
            val edgeV = Edge(it[1], it[2])
            val edgeU = Edge(it[0], it[2])
            graph[it[0]].add(edgeV)
            graph[it[1]].add(edgeU)
        }

        val queue = PriorityQueue<Edge>()
        val addedVertex = hashSetOf<Int>(start)
        graph[start].forEach {
            queue.add(it)
        }

        var mst = 0
        while (addedVertex.size < n) {
            val minEdge = queue.remove()
            if (addedVertex.contains(minEdge.v)) continue
            mst += minEdge.w
            addedVertex.add(minEdge.v)
            graph[minEdge.v].forEach {
                if (!addedVertex.contains(it.v)) {
                    queue.add(it)
                }
            }
        }
        return mst
    }

    data class Edge(val v: Int, val w: Int) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int = this.w.compareTo(other.w)
    }
}