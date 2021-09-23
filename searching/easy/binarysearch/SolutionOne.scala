/*
O(logn) time, O(1) space
(0, 1, 21, 33, 45, 45, 61, 71, 72, 73) target = 33
*/
object Solution {
  def main(args: Array[String]): Unit = {
    println(binarySearch(Array(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 200))  
  }

  def binarySearch(arr: Array[Int], target: Int): Int = {
    var left: Int = 0
    var right: Int = arr.length - 1
    while(left <= right) {
      var mid: Int = (left + right) / 2
      if(arr(mid) == target) return mid
      if(arr(mid) < target) left = mid + 1
      if(arr(mid) > target) right = mid - 1 
    }
    return -1
  }
}
