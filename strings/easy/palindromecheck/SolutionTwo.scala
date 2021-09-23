// recursion
//O(n) time, O(n) space

object Solution {
  def isPalindrome(inputStr: String, _i: Int = 0): Boolean = {
    var i: Int = _i
    var j: Int = inputStr.length - 1 - i
    if(i == j) return true
    else inputStr(i) == inputStr(j) && isPalindrome(inputStr, _i + 1)
  }
}

//tail recursion
//O(n) time, O(1) space, save space cause nothing is waiting for return

object Solution {
  def isPalindrome(inputStr: String, _i: Int = 0): Boolean = {
    var i: Int = _i
    var j: Int = inputStr.length - 1 - i
    if(i == j) return true
    if(inputStr(i) != inputStr(j)) return false
    return isPalindrome(inputStr, _i + 1)
  }
}