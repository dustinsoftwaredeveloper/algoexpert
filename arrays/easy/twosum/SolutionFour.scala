// two pointers

object Solution {
  def twoSum(arr: Array[Int], target: Int): Array[Int] = {
    val arrSorted: Array[Int] = arr.sorted
    var left: Int = 0
    var right: Int = arrSorted.length - 1
    while(left < right) {
      val currentSum: Int = arrSorted(left) + arrSorted(right)
      if(currentSum == target) return Array(arrSorted(left), arrSorted(right))
      else if(currentSum < target) left += 1
      else if(currentSum > target) right -= 1
    }
    val emptyArray: Array[Int] = Array()
    return emptyArray
  }
}

object Solution {
    def twoSum(arr: Array[Int], target: Int): Array[Int] = {
        val arrSorted: Array[Int] = arr.sortWith(_ < _)
        var left: Int = 0
        var right: Int = arr.length - 1
        while(left < right) {
          if(arr(left) + arr(right) == target) {
              return Array(arr(left), arr(right))
          }
          else if(arr(left) + arr(right) < target) {
              left += 1
          }
          else if(arr(left) + arr(right) > target) {
              right -= 1
          }
        }
        val emptyArray: Array[Int] = Array()
        return emptyArray
    }
}