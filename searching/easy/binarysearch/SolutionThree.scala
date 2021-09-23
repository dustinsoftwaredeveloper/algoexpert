
object SolutionThree extends App {
  def binarySearch(arr: Array[Int], target: Int): Int = {
    var left: Int = 0
    var right: Int = arr.length - 1
    while(left <= right) {
      var mid: Int = (left + right) / 2
      if(arr(mid) == target) return mid
      if(arr(mid) > target) right = mid - 1
      else left = mid + 1
    }
    return -1 
  }
  println(binarySearch(Array(0, 1, 21, 33, 45, 45, 61, 71, 72, 73), 33))
}
