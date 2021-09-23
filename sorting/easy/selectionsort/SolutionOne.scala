/*
(8, 5, 2, 9, 5, 6, 3) => (2, 3, 5, 5, 6, 8, 9)
*/

object SolutionOne {
  def main(args: Array[String]): Unit = {
    println(selectionSort(Array(8, 5, 2, 9, 5, 6, 3)).mkString(" "))
  }
  def selectionSort(arr: Array[Int]): Array[Int] = {
    var currentIdx: Int = 0
    var tracker: Int = 0
    var currentSmallest: Int = 0
    while(currentIdx < arr.length - 1) {
      currentSmallest = arr(currentIdx)
      for(i <- currentIdx + 1 to arr.length - 1) {
        if(arr(i) < currentSmallest) {
          currentSmallest = arr(i)
          tracker = i
        }
      }
      swapNums(currentIdx, tracker, arr)
      currentIdx += 1
    }
    return arr
  }
  def swapNums(currentIdx: Int, tracker: Int, arr: Array[Int]): Array[Int] = {
    var holder: Int = 0
    holder = arr(currentIdx)
    arr(currentIdx) = arr(tracker)
    arr(tracker) = holder
    return arr
  }
}
