/*
(8, 5, 2, 9, 5, 6, 3) => (2, 3, 5, 5, 6, 8, 9)
*/

object Solution {
  def main(args: Array[String]): Unit = {
    println(insertionSort(Array(8, 5, 2, 9, 5, 6, 3)).mkString(" "))
  }  
 
  def insertionSort(arr: Array[Int]): Array[Int] = {
    for(i <- 1 to arr.length - 1) {
      var j: Int = i
      while(j > 0 && arr(j) < arr(j - 1)) {
        swapEles(j, j - 1, arr)
        j -= 1 
      }
    } 
    return arr
  }

  def swapEles(idx: Int, prevIdx: Int, arr: Array[Int]): Array[Int] = {
    var holder: Int = arr(idx)
    arr(idx) = arr(prevIdx)
    arr(prevIdx) = holder
    return arr
  }
}
