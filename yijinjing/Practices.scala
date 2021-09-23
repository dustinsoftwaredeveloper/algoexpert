// try blend in aj hoge style repetition, learn different syntax and problem solving this way
// yijinjing twosum -> palindrome -> productSum-> minimumWaitingTime

/*
two sum
1 - brute force, for num in arr for numTwo in arr O(n^2) time, O(1)space
2 - two pointers
3 - subtract

val array: Array[Int] = Array(3, 5, -4, 8, 11, 1, -1, 6)
val targetSum = 10
Solution.twoSum(array, targetSum)
*/

//O(n^2) time, O(1) space
object Solution {
  def twoSum(arr: Array[Int], targetSum: Int): Array[Int] = {
    for(i <- 0 to arr.length - 2) {
      for(j <- i + 1 to arr.length -1) {
        if(arr(i) + arr(j) == targetSum) return Array(arr(i), arr(j))
      }
    }
    return Array()
  }
}

// O(nlogn + n) time, O(n) space
object Solution {
  def twoSum(arr: Array[Int], targetSum: Int): Array[Int] = {
    var left: Int = 0
    var right: Int = arr.length - 1
    arr = arr.sortWith(_ < _)
    while(left < right) {
      if(arr(left) + arr(right) > targetSum) right -= 1
      if(arr(left) + arr(right) < targetSum) left += 1
      if(arr(left) + arr(right) == targetSum) return Array(arr(left), arr(right))
    }
    return Array()
  }
}

//O(n) time, O(n) space
import scala.collection.mutable.ArrayBuffer

object Solution {
  def twoSum(arr: Array[Int], targetSum: Int): Array[Int] = {
    var numContainer: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    for(num <- arr) {
      if(numContainer.contains(targetSum - num)) return Array(num, targetSum - num)
      numContainer += num
    }
    return Array()
  }
}

/*
palindrome
1 - iterate backwards and compare, brute force
2 - 2 pointers

val string: String = "abcdcba"
val string: String = "abc"
Solution.isPalindrome(string)
*/ 
//brute force O(n^2) time, O(n) space
object Solution {
  def isPalindrome(inputStr: String): Boolean = {
    var newStr: String = ""
    for(i <- inputStr.length - 1 to 0 by -1) {
      newStr += inputStr(i)
    }
    if(inputStr == newStr) return true
    else return false
  }
}

//brute force using array instead of string
//O(n) time, O(n) space

import scala.collection.mutable.ArrayBuffer

object Solution {
  def isPalindrome(inputStr: String): Boolean = {
    var reversed: collection.mutable.ArrayBuffer[Char] = ArrayBuffer()
    for(i <- inputStr.length - 1 to 0 by -1) {
      reversed += inputStr(i)
    }
    if(reversed.mkString("") == inputStr) return true
    else return false
  }
}

//recursion "abcba" O(n/2) time O(n/2) space
object Solution {
  def isPalindrome(inputStr: String, i: Int = 0): Boolean = {
    var j: Int = inputStr.length - 1 - i
    if(i >= j) return true
    if(inputStr(i) == inputStr(j) && isPalindrome(inputStr, i + 1)) {
      return true
    } 
    return false
  }
}

//two pointers O(n/2) time, O(1) space

object Solution {
  def isPalindrome(inputStr: String): Boolean = {
    var left: Int = 0
    var right: Int = inputStr.length - 1
    while(left < right) {
      if(inputStr(left) != inputStr(right)) return false
      left += 1
      right -= 1
    }
    return true
  }
}

/*
product sum

val inputLis: List[Any] = List(5, 2, List(7, -1), 3, List(6, List(-13, 8), 4))
Solution.productSum(inputLis)
O(n) time, n = total ele including sub eles. O(l) space l= new list vals
*/

object Solution {
  def productSum(inputLis: List[Any], depth: Int = 1): Int = {
    var sum: Int = 0
    for(ele <- inputLis) {
      if(ele.isInstanceOf[List[Any]]) {
        val lis: List[Any] = ele.asInstanceOf[List[Any]]
        return productSum(lis, depth + 1)
      }
      else sum += ele.toString.toInt
    }
    return sum * depth
  }
}

/*
minimum waiting time
O(nlogn + n) time, O(n) space
val queries: Array[Int] = Array(3, 2, 1, 2, 6)
Solution.minimumWaitingTime(queries)

(1, 2, 2, 3, 6)
*/

object Solution {
  def minimumWaitingTime(queries: Array[Int]): Int = {
    val queriesSorted: Array[Int] = queries.sortWith(_ < _)
    var result: Int = 0
    for(i <- 0 to queries.length - 1) {
      result += queriesSorted(i) * (queries.length - 1 - i)
    }
    return result
  }
}