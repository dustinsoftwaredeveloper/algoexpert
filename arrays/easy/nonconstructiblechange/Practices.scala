/*
input
coins = Array(1, 2, 5)
output
4
input
coins = Array()
output
1
input 
coins = Array(5, 7, 1, 1, 2, 3 ,22)
output
20

coins = Array(5, 7, 1, 1, 2, 3 ,22).sortWith(_ < _)
(1, 1, 2, 3, 5, 7, 22)
(1, 2, 4) 7

one pointer, working with numbers in testing array
*/

object Solution {
  def nonConstructibleChange(coins: Array[Int]): Int = {
    if(coins.length < 1) return 1
    var currentSum: Int = 0
    for(i <- coins.sortWith(_ < _)) {
      if(i > currentSum + 1) return currentSum + 1
      currentSum += i
    }
    return currentSum + 1
  }
}