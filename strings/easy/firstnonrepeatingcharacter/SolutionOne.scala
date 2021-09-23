/*
val string: String = "abbcdcaf"
Solution.firstNonRepeatingCharacter(string)

val string: String = "aabb"
Solution.firstNonRepeatingCharacter(string)

time: O(n) space O(1)

*/

import scala.collection.mutable.Map

object Solution {
  def firstNonRepeatingCharacter(inputStr: String): Int = {
    // count
    var charRecord: collection.mutable.Map[Char, Int] = Map()
    for(char <- inputStr) {
      if(charRecord.get(char) == None) {
        charRecord += ((char, 1)) 
      }
      else charRecord(char) += 1
    }
    for((k, v) <- charRecord) {
      if(v == 1) return inputStr.indexOf(k)
    }
    return -1
  }
}

/*
val string: String = "a"
Solution.firstNonRepeatingCharacter(string)

val string: String = "aabb"
Solution.firstNonRepeatingCharacter(string)

improvement
O(2n) time, O(n) space

*/
// check unique
// new string = ""
// new string(indexOf(i)) = ""
// if newstring.contains(i) == false
// return inputStr.indexOf(i)

import scala.collection.mutable.StringBuilder

object Solution {
  def firstNonRepeatingCharacter(inputStr: String): Int = {
    var inputAlt: scala.collection.mutable.StringBuilder = new StringBuilder
    var indexHolder: Int = 0
    for(char <- inputStr) inputAlt.append(char)
    for(c <- inputAlt) {
      indexHolder = inputAlt.indexOf(c)
      inputAlt(inputAlt.indexOf(c)) = ' '
      if(inputAlt.contains(c) == false) return inputStr.indexOf(c)
      inputAlt(indexHolder) = c 
    }
    return -1
  }
}

/*
val string: String = "aabb"
Solution.firstNonRepeatingCharacter(string)
*/

//O(n^2) time O(1) space

object Solution {
  def firstNonRepeatingCharacter(inputStr: String): Int = {
    var duplicate: Boolean = false
    for(i <- 0 to inputStr.length - 1) {
      for(j <- 0 to inputStr.length - 1) {
        if(i != j && inputStr(i) == inputStr(j)) duplicate = true
      }
      if(duplicate == false) return i
      duplicate = false
    }
    return -1
  }
}