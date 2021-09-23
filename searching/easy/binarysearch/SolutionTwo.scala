/*
O(logn) time, O(logn) space
*/
object SolutionTwo {
  def main(args: Array[String]): Unit = {
    println(binarySearch(Array(0, 1, 21, 33, 45, 45, 61, 71, 71, 73), 33))
  }
  def binarySearch(arr: Array[Int], target: Int): Int = {
    return binarySearchHelper(arr, target, 0, arr.length - 1)
  }
  def binarySearchHelper(arr: Array[Int], target: Int, left: Int, right: Int): Int = {
    var mid: Int = (left + right) / 2
    if(left > right) return - 1
    if(arr(mid) == target) return mid
    if(arr(mid) < target) return binarySearchHelper(arr, target, mid + 1, right)
    else return binarySearchHelper(arr, target, left, mid - 1) 
  }
}
