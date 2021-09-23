//two pointers, one while loop
//O(n) time, O(1) space

object Solution {
  def isPalindrome(inputStr: String): Boolean = {
    var leftPointer: Int = 0
    var rightPointer: Int = inputStr.length - 1
    while(leftPointer < rightPointer) {
      if(inputStr(leftPointer) != inputStr(rightPointer)) return false
      leftPointer += 1
      rightPointer -= 1
    }
    return true
  }
}