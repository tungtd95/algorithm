package test

import graph.BFS
import graph.BFSofGraph
import graph.DFSofGraph
import graph.FindNumbOfIsland
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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
}