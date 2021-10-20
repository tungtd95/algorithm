package test

import org.junit.jupiter.api.Test
import sorting.MergeSort
import sorting.QuickSort
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

    @Test
    fun `test quick sort last pivot`() {
        val testList1 = createRandomList(4, 10)
        val quickSortResult1 = QuickSort().sort(testList1)
        assertEquals(testList1.sorted(), quickSortResult1)

        val testList2 = createRandomList(100, 1000)
        val quickSortResult2 = QuickSort().sort(testList2)
        assertEquals(testList2.sorted(), quickSortResult2)

        val testList3 = createRandomList(102005, 1000000)
        val quickSortResult3 = QuickSort().sort(testList3)
        assertEquals(testList3.sorted(), quickSortResult3)
    }

    @Test
    fun `test quick sort random pivot`() {
        val testList1 = createRandomList(4, 10)
        val quickSortResult1 = QuickSort().sortRandomPivot(testList1)
        assertEquals(testList1.sorted(), quickSortResult1)

        val testList2 = createRandomList(100, 1000)
        val quickSortResult2 = QuickSort().sortRandomPivot(testList2)
        assertEquals(testList2.sorted(), quickSortResult2)

        val testList3 = createRandomList(102005, 1000000)
        val quickSortResult3 = QuickSort().sortRandomPivot(testList3)
        assertEquals(testList3.sorted(), quickSortResult3)

        val testList4 = createRandomList(102005, 1000000).sorted()
        val quickSortResult4 = QuickSort().sortRandomPivot(testList4)
        assertEquals(testList4.sorted(), quickSortResult4)

        val testList5 = createRandomList(102005, 1000000).sortedDescending()
        val quickSortResult5 = QuickSort().sortRandomPivot(testList5)
        assertEquals(testList5.sorted(), quickSortResult5)
    }
}