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
    var arrHolder: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    var idxHolder: Int = 0
    arrSorted += arr(0) 
    for(i <- 1 to arr.length - 1) {
      if(arr(i) <= arrSorted(0)) {
        arrHolder += arr(i)
        for(ele <- arrSorted) {
          arrHolder += ele 
        }
        arrSorted = arrHolder
        arrHolder = null
        arrHolder = ArrayBuffer() 
      }
      if(arr(i) >= arrSorted(arrSorted.length - 1)) {
        arrSorted += arr(i)
      }
      else {
        idxHolder = arrSorted.length //review why can't use arrSorted.length - 1 
        for(j <- arrSorted.length - 1 to 0 by -1) {
          if(arr(i) < arrSorted(j)) {idxHolder -= 1}
        }
        for(k <- 0 to idxHolder - 1) {
          arrHolder += arrSorted(k) 
        }
        arrHolder += arr(i)
        for(l <- idxHolder to arrSorted.length - 1) {
          arrHolder += arrSorted(l)
        }
        arrSorted = arrHolder
        arrHolder = null
        arrHolder = ArrayBuffer() 
      } 
    }
    return arrSorted.toArray
  }
}
