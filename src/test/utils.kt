package test
import kotlin.random.Random

fun createRandomList(size: Int, maxNumb: Int = 100000): List<Int> {
    val list = arrayListOf<Int>()
    for (i in 0..size) {
        list.add(Random.nextInt(maxNumb))
    }
    return list
}

fun createRandomListInput(size: Int, maxNumb: Int = 100000) {
    for (i in 0..size) {
        print("${i+1}, ")
    }
}