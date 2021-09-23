//brute force, one for loop
//O(n) time, O(n) space 
// actually O(n2) time cause string concatenation will iterate over all eles
// inside the string

object Solution {
  def palindromeCheck(inputStr: String): Boolean = {
    var inputStrReversed: StringBuilder = new StringBuilder("")
    for(j <- inputStr.length - 1 to 0 by -1) {
      inputStrReversed += inputStr(j)
    }
    return inputStr == inputStrReversed.toString
  }
}

// brute force, one for loop, using array instead of string
// takes O(n) time, O(n) space
// adding ele to array doesn't have to iterate over every ele in string

import scala.collection.mutable.ArrayBuffer

object Solution {
  def palindromeCheck(inputStr: String): Boolean = {
    var inputStrReversed: ArrayBuffer[Char] = ArrayBuffer()
    for(j <- inputStr.length - 1 to 0 by -1) {
      inputStrReversed += inputStr(j)
    }
  return inputStr == inputStrReversed.mkString
  }
}