/*
val inputLis: List[Any] = List(5, 2, List(7, -1), 3, List(6, List(-13, 8), 4))
Solution.productSum(inputLis)
*/


object Solution {
  def productSum(inputLis: List[Any], depth: Int = 1): Int = {
    var sum: Int = 0
    for (el <- inputLis) {
      if (el.isInstanceOf[List[Any]]) {
        val ls: List[Any] = el.asInstanceOf[List[Any]]
        sum += productSum(ls, depth + 1)
      } else {
        sum += el.toString.toInt
      }
    }
    return sum * depth
  }
}

/*
val inputArr: Array[Any] = Array(5, 2, Array(7, -1), 3, Array(6, Array(-13, 8), 4))
Solution.productSum(inputArr)

error number format exception
*/

object Solution {
  def productSum(inputArr: Array[Any], depth: Int = 1): Int = {
    var sum: Int = 0
    for (el <- inputArr) {
      if (el.isInstanceOf[Array[Any]]) {
        val ls: Array[Any] = el.asInstanceOf[Array[Any]]
        sum += productSum(ls, depth + 1)
      } else {
        sum += el.toString.toInt
      }
    }
    return sum * depth
  }
}