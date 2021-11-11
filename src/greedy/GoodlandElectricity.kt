package greedy

import test.printList

class GoodlandElectricity {
    fun pylons(k: Int, arr: Array<Int>): Int {
//        println(arr.indexOfLast {
//            it == 1
//        })
        // Write your code here
        var currentPlantedCity = -1
        var toPlantedCity = k - 1
        var plantCount = 0
        while (toPlantedCity < arr.size) {
            if (arr[toPlantedCity] == 0) {
                var canCover = false
                for (j in toPlantedCity downTo (currentPlantedCity + 1)) {
                    if (arr[j] == 1) {
//                        println("WTF: $j >> ${arr[j]}")
                        currentPlantedCity = j
                        toPlantedCity = j + k * 2 - 1
                        plantCount++
                        canCover = true
                        break
                    }
                }
                if (!canCover) return -1
            } else {
                currentPlantedCity = toPlantedCity
                toPlantedCity += k * 2 - 1
                plantCount++
            }
//            println("current planted = $currentPlantedCity >>> to plant = $toPlantedCity")

            if (toPlantedCity >= arr.size && arr.size - 1 - currentPlantedCity >= k) {
                var canCover = false
//                println("WTF3: ${arr.size - 1} >>>>> ${(currentPlantedCity + k - 1)}")
                for (j in arr.size - k until arr.size) {
                    if (arr[j] == 1) {
//                        println("WTF2: $j >> ${arr[j]}")
                        plantCount++
                        canCover = true
                        break
                    }
                }
                if (!canCover) return -1
            }
//            println("current planted: $currentPlantedCity >>> to plant: $toPlantedCity")
        }

        return plantCount
    }
}