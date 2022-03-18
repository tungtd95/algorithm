package search

object SearchAlg {

    // input: original list
    //        derived list

    // output: derived list from original list

    fun searchNaive(toSearchIdx: List<Int>, models: List<Model>): List<Model> {
        val result = arrayListOf<Model>()
        toSearchIdx.forEach { idx ->
            for (it in models) {
                if (it.idx == idx) {
                    result.add(it)
                    break
                }
            }
        }
        return result
    }

    fun searchOptimized(toSearchIdx: List<Int>, models: List<Model>): List<Model> {
        val modelsMap: HashMap<Int, Model> = hashMapOf()
        models.forEach {
            modelsMap[it.idx] = it
        }
        return toSearchIdx.map { modelsMap[it]!! }
    }
}

data class Model(
    val idx: Int, val name: String
)