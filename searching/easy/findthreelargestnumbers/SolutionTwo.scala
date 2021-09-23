/*(10, 5, 9, 10, 12) => (10, 10, 12)
O(n) time, O(1) space
*/
object SolutionTwo extends App {
  def findThreeLargestNumbers(arr: Array[Int]): Array[Int] = {
    var threeLargest: Array[Int] = new Array[Int](3)
    for(num <- arr) findHelper(num, threeLargest)
    return threeLargest
  }
  def findHelper(num: Int, threeLargest: Array[Int]): Array[Int] = {
    if(threeLargest(2) == 0 || num > threeLargest(2)) changeNums(2, num, threeLargest)
    else if(threeLargest(1) == 0 || num > threeLargest(1)) changeNums(1, num, threeLargest)
    else if(threeLargest(0) == 0 || num > threeLargest(0)) changeNums(0, num, threeLargest)
    return threeLargest
  }
  def changeNums(idx: Int, num: Int, threeLargest: Array[Int]): Array[Int] = {
    for(i <- 0 to idx) {
      if(i == idx) threeLargest(i) = num
      else threeLargest(i) = threeLargest(i + 1)
    }
    return threeLargest 
  } 
  println(findThreeLargestNumbers(Array(141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7)).mkString(" ")) 
}
