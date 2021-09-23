//two pointers
// takes O(n) time, O(n) space

object Solution {
  def sortedSquares(arr: Array[Int]): Array[Int] = {
    val arrSquared: Array[Int] = Array.fill(arr.length)(0)
    var left: Int = 0
    var right: Int = arr.length - 1
    for(i <- arr.length - 1 to 0 by -1) {
      var leftValue: Int = arr(left)
      var rightValue: Int = arr(right)
      if(leftValue.abs > rightValue.abs) {
        arrSquared(i) = leftValue * leftValue
        left += 1
      }
      else {
           arrSquared(i) = rightValue * rightValue
           right -=1
           }
    }
    return arrSquared
  }
}