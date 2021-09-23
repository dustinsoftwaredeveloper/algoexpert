/*
sample input
string = "abcdcba"
sample output
true
*/

//brute force
// O(n2) time, O(n) space

object Solution {
  def isPalindrome(inputStr: String): Boolean = {
    var inputStrReversed: StringBuilder = new StringBuilder
    for(i <- inputStr.length - 1 to 0 by -1) {inputStrReversed += inputStr(i)}
    return inputStr == inputStrReversed.toString
  }
}

//brute force, array
//O(n)time, O(n) space

import scala.collection.mutable.ArrayBuffer

object Solution {
  def isPalindrome(inputStr: String): Boolean = {
    var inputStrReversed: collection.mutable.ArrayBuffer[Char] = ArrayBuffer()
    for(i <- inputStr.length - 1 to 0 by -1) {inputStrReversed += inputStr(i)}
    return inputStr == inputStrReversed.mkString
  }
}

//recursion
// O(n) time, O(n) space because of recursion call stack

object Solution {
  def isPalindrome(inputStr: String, _leftPointer: Int = 0): Boolean = {
    var leftPointer: Int = _leftPointer
    var rightPointer: Int = inputStr.length - 1 - _leftPointer
    if(leftPointer == rightPointer) return true
    return inputStr(leftPointer) == inputStr(rightPointer) && isPalindrome(inputStr, _leftPointer + 1)
  }
}

//tail recursion
// O(n) time, O(1) space

object Solution {
  def isPalindrome(inputStr: String, _leftPointer: Int = 0): Boolean = {
    var leftPointer: Int = _leftPointer
    var rightPointer: Int = inputStr.length - 1 - _leftPointer
    if(leftPointer == rightPointer) return true
    if(inputStr(leftPointer) != inputStr(rightPointer)) return false
    return isPalindrome(inputStr, _leftPointer + 1)
  }
}


// pointers
// O(n) time, O(1) space

object Solution {
  def isPalindrome(inputStr: String): Boolean = {
    var left: Int = 0
    var right: Int = inputStr.length - 1
    if(left == right) return true
    while(left < right) {
      if(inputStr(left) != inputStr(right)) return false
      left += 1
      right -= 1
    }
    return true
  }
}

// recursion
//0(n) time, O(n) space

object Solution {
  def isPalindrome(inputStr: String, _left: Int = 0): Boolean = {
    var left: Int = _left
    var right: Int = inputStr.length - 1 - _left
    if(left >= right) return true
    return inputStr(left) == inputStr(right) && isPalindrome(inputStr, _left + 1)
  }
}