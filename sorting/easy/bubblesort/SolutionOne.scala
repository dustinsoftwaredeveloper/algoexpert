/*
Array(8, 5, 2, 9, 5, 6, 3) -> Array(2, 3, 5, 5, 6, 8, 9)
var lastIdx = arr.length - 2 

while sorted = false 
  for i <- 0 to lastIdx 
    if(arr(i) > arr(i + 1) { arr(i) = holder; arr(i) = arr (i + 1); arr(i + 1) = holder;
      holderxswapped = true
      lastIdx = lastIdx - 1 
  if swapped == true {
  sorted = sortedChecker(inputArr, lastIdx)
  swapped = false
  }
  else sorted = true
def sortedChecker(inputArr: Array[Int], lastIdx: Int): Boolean = {
  fori <- 0 to lastIdx
    if arr(i) > lastIdx return false
  return true 
}   


val inputArr: Array[Int} = Array(8, 5, 2, 9, 5, 6, 3) 
Solution.bubbleSort(inputArr)
O(n^2) time, O(n) space in scala since _inputArr is a val
*/
object SolutionOne extends App {
 
  def bubbleSort(_inputArr: Array[Int]): Array[Int] = {
    var inputArr: Array[Int] = _inputArr
    var sortIdxHolder: Int = inputArr.length - 2
    var eleHolder: Int = 0 
    var sorted: Boolean = false
    var swapped: Boolean = false
    while(sorted == false) {
      for(i <- 0 to sortIdxHolder) {
        if(inputArr(i) > inputArr(i + 1)) {
          eleHolder = inputArr(i)
          inputArr(i) = inputArr(i + 1)
          inputArr(i + 1) = eleHolder
          swapped = true 
        } 
      }
      sortIdxHolder -= 1
      if(swapped == true) {
        sorted = sortedChecker(inputArr, sortIdxHolder)
        swapped = false 
      }
      else sorted = true 
    }
    return inputArr 
  }

  def sortedChecker(arr: Array[Int], endIndex: Int): Boolean = {
    for(j <- 0 to endIndex) {
      if(arr(j) > arr(j + 1)) return false 
    }
    return true 
  }

  for(num <- bubbleSort(Array(8, 5, 2, 9, 5, 6, 3))) {
    println(num + " ")
  }
}
