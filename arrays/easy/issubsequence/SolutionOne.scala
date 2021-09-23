//two pointers while loop
//O(n) time, O(1) space

object Solution {
  def isSubsequence(s: String, t: String): Boolean = {
    var sPointer: Int = 0
    var tPointer: Int = 0
    while(sPointer < s.length && tPointer < t.length) {
        if(s(sPointer) == t(tPointer)) sPointer += 1
        tPointer += 1
    }
    return sPointer == s.length
  }
}