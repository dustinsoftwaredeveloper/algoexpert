// brute force

object Solution {
  def twoSum(arr: Array[Int], target: Int): Array[Int] = {
    for (i <- 0 to arr.length - 1) {
      var firstNum = arr(i)
      for (j <- i + 1 to arr.length) {
        var secondNum = arr(j)
        if (firstNum + secondNum == target) {
          return Array(firstNum, secondNum)
        }
      }
    }
    var emptyArray: Array[Int] = Array()
    return emptyArray 
  }
}

object Solution {
    def twoSum(arr: Array[Int], target: Int): Array[Int] = {
        for(i <- 0 to arr.length - 1) {
            for(j <- i + 1 to arr.length - 1) {                
                if(arr(i) + arr(j) == target) {return Array(arr(i), arr(j))}                
            }
        }
        val emptyArray: Array[Int] = Array()
        return emptyArray
    }
}