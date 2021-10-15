package test

import org.junit.jupiter.api.Test
import sorting.MergeSort
import sorting.SortingSimple
import kotlin.test.assertEquals

class SortingTest {

    @Test
    fun `test insertion sort`() {
        val testList1 = createRandomList(4, 10)
        val insertionSortResult1 = SortingSimple().insertionSort(testList1)
        assertEquals(testList1.sorted(), insertionSortResult1)

        val testList2 = createRandomList(100, 1000)
        val insertionSortResult2 = SortingSimple().insertionSort(testList2)
        assertEquals(testList2.sorted(), insertionSortResult2)

        val testList3 = createRandomList(10000, 1000000)
        val insertionSortResult3 = SortingSimple().insertionSort(testList3)
        assertEquals(testList3.sorted(), insertionSortResult3)
    }

    @Test
    fun `test merge sort`() {
        val testList1 = createRandomList(4, 10)
        val mergeSortResult1 = MergeSort().mergeSort(testList1)
        assertEquals(testList1.sorted(), mergeSortResult1)

        val testList2 = createRandomList(100, 1000)
        val mergeSortResult2 = MergeSort().mergeSort(testList2)
        assertEquals(testList2.sorted(), mergeSortResult2)

        val testList3 = createRandomList(102005, 1000000)
        val mergeSortResult3 = MergeSort().mergeSort(testList3)
        assertEquals(testList3.sorted(), mergeSortResult3)
    }
}