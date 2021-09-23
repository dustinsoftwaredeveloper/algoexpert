/*
val inputLis: List[Any] = List(5, 2, List(7, -1), 3, List(6, List(-13, 8), 4))
Solution.productSum(inputLis)

O(n) time, n is total eles including sub ele inside of inputLis
O(d) space, d is depth
*/

object Solution {
  def productSum(inputLis: List[Any], depth: Int = 1): Int = {
    var sum: Int = 0
    for(ele <- inputLis) {
      if(ele.isInstanceOf[List[Any]]) {
        val ls: List[Any] = ele.asInstanceOf[List[Any]]
        sum += productSum(ls, depth + 1)
      }
      else {
        sum += ele.toString.toInt
      }
    }
    return sum * depth
  }
}