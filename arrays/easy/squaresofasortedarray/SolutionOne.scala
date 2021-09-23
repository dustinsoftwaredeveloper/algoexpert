//brute force
//O(nlogn) time, O(n) space

import scala.collection.mutable.ArrayBuffer

object Solution {
  def sortedSquares(arr: Array[Int]): Array[Int] = {
    var arrSquared: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    for(i <- arr) {
      var j: Int = i * i
      arrSquared += j
    }
    return arrSquared.toArray.sortWith(_ < _)
  }
}