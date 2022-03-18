package graph

import java.util.*

fun main() {
    Test().testQueue()
}

class Test {
    private val priorityQueue = PriorityQueue<Model>()
    fun testQueue() {
        val models = listOf(Model("A", 2), Model("B", 1), Model("C", 3), Model("D", 0))
        models.forEach { priorityQueue.add(it) }
        printQueue()

        models[2].apply { order = -1 }
        priorityQueue
        printQueue()
    }

    private fun printQueue() {
        priorityQueue.forEach { print("${it.name}:${it.order} > ") }
        println()
    }
}

data class Model(val name: String, var order: Int) : Comparable<Model> {
    override fun compareTo(other: Model): Int = this.order.compareTo(other.order)
}