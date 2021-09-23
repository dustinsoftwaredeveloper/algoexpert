/*(10, 5, 9, 10, 12) => (10, 10, 12)
no sorting the input array, return a sorted array
O(n) time, O(k) space, k is the amount of largest numbers
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def main(args: Array[String]): Unit = {
    println(findThreeLargestNumbers(Array(141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7)).mkString(" ")) 
    println(findThreeLargestNumbers(Array(12, 12, 10)).mkString(" "))
  }
  def findThreeLargestNumbers(arr: Array[Int]): Array[Int] = {
    var currentLargest: Int = arr(0)
    var currentLargestIdx: Int = 0
    var idxesOfLargestNums: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    var largestNums: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    while(largestNums.length < 3) {
      for(j <- 0 to arr.length - 1) {
        if(idxesOfLargestNums.contains(j) == false) {
          currentLargest = arr(j)
          currentLargestIdx = j 
        }
      }
      for(i <- 0 to arr.length - 1) {
        if(idxesOfLargestNums.contains(i) == false && arr(i) > currentLargest) {
          currentLargest = arr(i)
          currentLargestIdx = i
        }
      }
      largestNums += currentLargest
      idxesOfLargestNums += currentLargestIdx
    }
    return sortArr(largestNums).toArray 
  }
  def sortArr(arr: collection.mutable.ArrayBuffer[Int]): collection.mutable.ArrayBuffer[Int] = {
    var holder: Int = arr(0)
    arr(0) = arr(arr.length - 1)
    arr(arr.length - 1) = holder
    return arr
  }
} 

