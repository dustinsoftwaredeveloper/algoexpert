//Hash Table

object Solution {
    def twoSum(arr: Array[Int], target: Int): Array[Int] = {
      val arrHashTable = scala.collection.mutable.HashMap[Int, Int]()
      
      for(i <- arr.indices) {
        if(arrHashTable.contains(target - arr(i))) {
          return Array(target - arr(i), arr(i))
        }
        else arrHashTable.put(arr(i), i)
      }
      var emptyArray: Array[Int] = Array()
      return emptyArray
    }
}

import scala.collection.mutable

object Solution {
    def twoSum(arr: Array[Int], target: Int): Array[Int] = {
        var arrHashTable: collection.mutable.Map[Int, Boolean] = collection.mutable.Map[Int, Boolean]()
        for(i <- 0 to arr.length) {
            if(arrHashTable.contains(target - arr(i))) {
                return Array((target - arr(i)), arr(i))
            }
            else {
                arrHashTable = arrHashTable + ((arr(i), true))
            }
        }
        val emptyArray: Array[Int] = Array()
        return emptyArray
    }
}