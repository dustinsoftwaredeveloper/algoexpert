/*
a function takes in an array of ints and return sorted version
(8, 5, 2, 9, 5, 6, 3) => (2, 3, 5, 5, 6, 8, 9)
for(i <- 0 to arr.length - 1) {

}
*/
import scala.collection.mutable.ArrayBuffer

object SolutionOne {
  def main(args: Array[String]): Unit = {
    println(insertionSort(Array(8, 5, 2, 9, 5, 6, 3)).mkString(" "))    
  }

  def insertionSort(arr: Array[Int]): Array[Int] = {
    var arrSorted: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    arrSorted += arr(0) 
    for(i <- 1 to arr.length - 1) {
      if(arr(i) <= arrSorted(0)) {
        prependEle(arr(i), arrSorted) 
      }
      if(arr(i) >= arrSorted(arrSorted.length - 1)) {
        appendEle(arr(i), arrSorted)
      }
      else {
        insertEle(arr(i), arrSorted)
      } 
    }
    return arrSorted.toArray
  }
  def prependEle(ele: Int, arr: collection.mutable.ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var numHolder1: Int = 0
    var numHolder2: Int = 0
    numHolder1 = arr(0)
    arr(0) = ele
    for(i <- 1 to arr.length -2) {
      numHolder2 = arr(i)
      arr(i) = numHolder1
      numHolder1 = numHolder2 
    }
    numHolder2 = arr(arr.length - 1)
    arr(arr.length - 1) = numHolder1
    arr += numHolder2
    return arr
  }
  def appendEle(ele: Int, arr: collection.mutable.ArrayBuffer[Int]): ArrayBuffer[Int] = {
    arr += ele
    return arr
  }
  def insertEle(ele: Int, arr: collection.mutable.ArrayBuffer[Int]): ArrayBuffer[Int] = {
    var insertIdx: Int = 0
    var numHolder1: Int = 0
    var numHolder2: Int = 0
    for(num <- arr) {if(ele > num) {insertIdx += 1}}
    numHolder1 = arr(insertIdx)
    arr(insertIdx) = ele
    for(i <- insertIdx + 1 to arr.length - 2) {
      numHolder2 = arr(i)
      arr(i) = numHolder1
      numHolder1 = numHolder2 
    }
    numHolder2 = arr(arr.length - 1)
    arr(arr.length - 1) = numHolder1
    arr += numHolder2
    return arr 
  }
}
