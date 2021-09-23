object SolutionTwo {
  def main(args: Array[String]): Unit = {
    println(bubbleSort(Array(8, 5, 2, 9, 3, 6, 3)).mkString(" ")) 
  }
  
  def bubbleSort(_inputArr: Array[Int]): Array[Int] = {
    var inputArr: Array[Int] = _inputArr
    var sorted: Boolean = false
    while(sorted == false) {
      sorted = true 
      for(i <- 0 to inputArr.length - 2) {
        if(inputArr(i) > inputArr(i + 1)) {
          sorted = false 
          swapNums(i, i + 1, inputArr)
        } 
      } 
    }
    return inputArr 
  }
  
  def swapNums(idx: Int, nextIdx: Int, arr: Array[Int]): Array[Int] = {
    var intHolder: Int = arr(idx)
    arr(idx) = arr(nextIdx)
    arr(nextIdx) = intHolder
    return arr 
  }
}
