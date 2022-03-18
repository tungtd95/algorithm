package test

import org.junit.jupiter.api.Test
import search.Model
import search.SearchAlg
import kotlin.random.Random
import kotlin.test.assertEquals

class SearchTest {

//    @Test
//    fun testSearch() {
//        val original = listOf(
//            Model(0, "name_0"),
//            Model(1, "name_1"),
//            Model(2, "name_2"),
//            Model(3, "name_3"),
//            Model(4, "name_4"),
//            Model(5, "name_5")
//        )
//        val toSearchIdx = listOf(5, 3, 0)
//        val result = SearchAlg.searchNaive(toSearchIdx, original)
//        println("search result $result")
//        assertEquals(result[0], original[5])
//
//        val resultOptimized = SearchAlg.searchOptimized(toSearchIdx, original)
//        println("search optimized result $resultOptimized")
//        assertEquals(resultOptimized[0], original[5])
//    }

    @Test
    fun testSearchNaivePerformance() {
        val original = arrayListOf<Model>()
        for (i in 0..1000000) {
            original.add(Model(idx = i, name = "name_$i"))
        }
        original.shuffle()

        val toSearchIdx = arrayListOf<Int>()
        for (i in 0..1000) {
            toSearchIdx.add(Random.nextInt(1000000))
        }

        SearchAlg.searchNaive(toSearchIdx, original)
    }

    @Test
    fun testSearchOptimizedPerformance() {
        val original = arrayListOf<Model>()
        for (i in 0..1000000) {
            original.add(Model(idx = i, name = "name_$i"))
        }
        original.shuffle()

        val toSearchIdx = arrayListOf<Int>()
        for (i in 0..1000) {
            toSearchIdx.add(Random.nextInt(1000000))
        }

        SearchAlg.searchOptimized(toSearchIdx, original)
    }
}