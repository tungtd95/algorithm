package test

import graph.*
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GraphTest {

    @Test
    fun `test bfs`() {
        assert(arrayOf(6, 6, -1).isEqualTo(BFS().bfs(4, 2, arrayOf(arrayOf(1, 2), arrayOf(1, 3)), 1)))
        assert(arrayOf(-1, 6).isEqualTo(BFS().bfs(3, 1, arrayOf(arrayOf(2, 3)), 2)))
        assert(
            arrayOf(6, 6, 12, -1).isEqualTo(
                BFS().bfs(
                    5,
                    3,
                    arrayOf(arrayOf(1, 2), arrayOf(1, 3), arrayOf(3, 4), arrayOf(4, 2), arrayOf(2, 4)),
                    1
                )
            )
        )
        assert(
            arrayOf(6, -1, -1, -1, -1, -1, 12, -1, 12).isEqualTo(
                BFS().bfs(
                    10,
                    6,
                    arrayOf(
                        arrayOf(3, 1),
                        arrayOf(10, 1),
                        arrayOf(10, 1),
                        arrayOf(3, 1),
                        arrayOf(1, 8),
                        arrayOf(5, 2)
                    ),
                    3
                )
            )
        )
    }

    @Test
    fun `test bfs of graph`() {
        assert(
            BFSofGraph().bfsOfGraph(
                5,
                arrayListOf(arrayListOf(1, 2, 3), arrayListOf(), arrayListOf(4), arrayListOf(), arrayListOf())
            ).toArray().isEqualTo(arrayOf(0, 1, 2, 3, 4))
        )
    }

    @Test
    fun `test dfs of graph`() {
        assert(
            DFSofGraph().dfsOfGraph(
                5,
                arrayListOf(arrayListOf(1, 2, 4), arrayListOf(0), arrayListOf(0), arrayListOf(4), arrayListOf(0, 3))
            ).toArray().isEqualTo(arrayOf(0, 1, 2, 4, 3))
        )
        assert(
            DFSofGraph().dfsOfGraph(
                4,
                arrayListOf(arrayListOf(1, 3), arrayListOf(2), arrayListOf(1), arrayListOf(0))
            ).toArray().isEqualTo(arrayOf(0, 1, 2, 3))
        )
    }

    @Test
    fun `test find numb of island`() {
        assertEquals(
            FindNumbOfIsland().numIslands(
                arrayOf(
                    charArrayOf('0', '1', '1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '1', '1', '0', '1', '0')
                )
            ), 2
        )
        assertEquals(
            FindNumbOfIsland().numIslands(
                arrayOf(
                    charArrayOf('0', '1'),
                    charArrayOf('1', '0'),
                    charArrayOf('1', '1'),
                    charArrayOf('1', '0'),
                )
            ), 1
        )
    }

    @Test
    fun `test bipartite graph`() {
        assertTrue(BipartiteGraph().isBipartite(3, arrayListOf(arrayListOf(1), arrayListOf(0, 2), arrayListOf(1))))
        assertFalse(
            BipartiteGraph().isBipartite(
                4,
                arrayListOf(arrayListOf(2, 3), arrayListOf(3), arrayListOf(0, 3), arrayListOf(0, 1, 2))
            )
        )
        assertFalse(
            BipartiteGraph().isBipartite(
                6,
                arrayListOf(
                    arrayListOf(1, 2),
                    arrayListOf(0),
                    arrayListOf(0),
                    arrayListOf(4, 5),
                    arrayListOf(3, 5),
                    arrayListOf(3, 4)
                )
            )
        )
    }

    @Test
    fun `test kruskal`() {
        assertEquals(
            12,
            Kruskal.kruskals(4, listOf(1, 1, 4, 2, 3, 3), listOf(2, 3, 1, 4, 2, 4), listOf(5, 3, 6, 7, 4, 5))
        )

        val inputStream = File("${Paths.get("").toAbsolutePath()}/src/test/test_kruskal.dat").inputStream()
        val from = arrayListOf<Int>()
        val to = arrayListOf<Int>()
        val weight = arrayListOf<Int>()
        inputStream.bufferedReader().useLines {
            it.forEach { str ->
                val rawStringArr = str.split(" ")
                from.add(rawStringArr[0].toInt())
                to.add(rawStringArr[1].toInt())
                weight.add(rawStringArr[2].toInt())
            }
        }
        assertEquals(6359060, Kruskal.kruskals(1000, from, to, weight))
    }

    @Test
    fun `test prim`() {
        assertEquals(
            15,
            Prim().prims(
                5,
                arrayOf(
                    arrayOf(1, 2, 3),
                    arrayOf(1, 3, 4),
                    arrayOf(4, 2, 6),
                    arrayOf(5, 2, 2),
                    arrayOf(2, 3, 5),
                    arrayOf(3, 5, 7)
                ),
                1
            )
        )
    }

    @Test
    fun `test dijkstra original`() {
        assertTrue(
            Dijkstra().shortestReach(
                4,
                arrayOf(
                    arrayOf(1, 2, 24),
                    arrayOf(1, 4, 20),
                    arrayOf(3, 1, 3),
                    arrayOf(4, 3, 12)
                ),
                1
            ).isEqualTo(arrayOf(24, 3, 15))
        )
    }

    @Test
    fun `test dijkstra`() {
        val inputStream = File("${Paths.get("").toAbsolutePath()}/src/test/test_dijkstra.dat").inputStream()
        val result = arrayListOf<Array<Int>>()
        inputStream.bufferedReader().useLines {
            val iterator = it.iterator()
            var t = iterator.next().toInt()
            while (t > 0) {
                t--
                val mn = iterator.next().split(" ")
                val n = mn[0].toInt()
                val m = mn[1].toInt()
                val edges = Array(m) { Array(3) { 0 } }
                for (i in 0 until m) {
                    val edge = iterator.next().split(" ")
                    edges[i][0] = edge[0].toInt()
                    edges[i][1] = edge[1].toInt()
                    edges[i][2] = edge[2].toInt()
                }
                val s = iterator.next().toInt()
                result.add(Dijkstra().shortestReach(n, edges, s))
            }
        }
        var resultInStr = ""
        result.forEach {
            resultInStr += it.joinToString(separator = " ")
            resultInStr += "\n"
        }
        val expectResultInStr = "20 25 25 68 86 39 22 70 36 53 91 35 88 27 30 43 54 74 41\n" +
                "9 8 8 8 12 7 15 8 4 1 12 9 7 10 4 10 10 4 1 7 12 7 11 12 15 10 5 11 6 7 9 11 9 7 7 14 5 13 6 8 10 7 4 9 3 5 5 9 13 1 8 11 4 9 6 7 7 8 11 6 10 7 8 9 13 9 12 8 3 5 7 15 6 10 11 5 11\n" +
                "154 90 186 190 178 114 123 -1 -1 123 -1 104 -1 -1 -1 207 134 123 98 155 -1 198 68 90 170 135 -1 103 145 -1 54 111 163 173 115 87 159 75 -1 94 102 -1 76 67 167 138 216 -1 172 102 212 163 103 112 -1 182 49 145 92 -1 -1 194 -1 182 -1 201 96 -1 85 121 108 161 130 100 120 -1 -1 118 215 92 156 162 163 168 71 110 -1 -1 190 217 100 105 178\n" +
                "13 30 17 33 16 9 31 34 14 20 21 19 24 34 27 42 15 16 19 23 18 21 11 21 28 15 15 45 18 26 17 20 16 28 27 16 22 21 18 21 34 14 26 27 11 23 17 24 27 22 19 18 21 17 17 22 14 20 12 27 21 10 42 10 25 19 22\n" +
                "3 6 8 11 7 12 10 18 4 8 3 6 12 1 2 10 1 8 5 6 9 9 8 17 11 12 8\n" +
                "3 4 5 3 4 5 5 4 4 7 6 4 1 4 5 5 5 4 5 6 5 6 4 5 3 5 5 6 2 6 3 3 6 5 3 6 3 2 6 4 1 6 3 4 5 6 7 7 3 6 3 5 3 5 4 7 4 4 6 4 5 5 5 4 2 2 3 6 4 6 4 4 5 4 6 3 5 5 4 4 4 2 1 3 3 3 2\n"
        assertEquals(expectResultInStr, resultInStr)
    }
}