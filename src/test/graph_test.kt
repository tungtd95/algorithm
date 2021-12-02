package test

import graph.BFS
import org.junit.jupiter.api.Test

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
}